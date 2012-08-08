package org.vamdc.dictionary.requestableLogic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import org.vamdc.dictionary.Requestable;
import org.vamdc.dictionary.RequestableLogic;

/**
 * Class implementing relation logic between requestables
 * @author doronin
 *
 */
public class RequestableLogicImpl implements RequestableLogic {

	private Map<Requestable, KeywordRelation> keys = new HashMap<Requestable, KeywordRelation>();

	public RequestableLogicImpl(){
		initLogic();

	}
	
	@Override
	public boolean isEnabled(Collection<Requestable> askedKeys,Requestable keyword){
		if (askedKeys==null || keyword==null)
			throw new IllegalArgumentException();
		if (askedKeys.size()==0)
			return true;
		if (keys.get(keyword)!=null)
			return keys.get(keyword).isEnabled(askedKeys);
		return true;
	}
	
	@Override
	public Collection<Requestable> normalizeKeys(Collection<Requestable> asked){
		EnumSet<Requestable> result = EnumSet.copyOf(asked);
		for (Requestable key:Requestable.values()){
			getRelation(key).normalize(result);
		}
		return result;
	}
	
	@Override
	public Collection<Requestable> enableKey(Collection<Requestable> asked,Requestable keyword){
		asked.add(keyword);
		return normalizeKeys(asked);
	}
	
	@Override
	public Collection<Requestable> disableKey(Collection<Requestable> asked,Requestable keyword){
		if (asked.size()==0)
			asked=normalizeKeys(EnumSet.allOf(Requestable.class));
		if (asked.contains(keyword)){
			asked.remove(keyword);
			return normalizeKeys(asked);
		}else{
			for (KeywordRelation enabler:getRelation(keyword).getEnablingMe()){
				if (enabler.isEnabled(asked)){
					asked.addAll(enabler.enabledByMe);
					asked.remove(enabler.getKey());
				}
			}
			asked.remove(keyword);
			return normalizeKeys(asked);
		}
			
	}
	
	@Override
	public Collection<Requestable> getLogicChildren(Requestable key) {
		return getRelation(key).getChildren();
	}
	
	private void initLogic() {
		getRelation(Requestable.Species)
			.addEnabledKeyword(Requestable.Atoms)
			.addEnabledKeyword(Requestable.Molecules)
			.addEnabledKeyword(Requestable.Particles)
			.addEnabledKeyword(Requestable.Solids)
			.setGrouping(true);
		
		getRelation(Requestable.States)
			.addEnabledKeyword(Requestable.Species)
			.addEnabledKeyword(Requestable.AtomStates)
			.addEnabledKeyword(Requestable.MoleculeStates)
			.setGrouping(true);
		
		getRelation(Requestable.AtomStates)
			.addEnabledKeyword(Requestable.Atoms);
		
		getRelation(Requestable.MoleculeStates)
			.addEnabledKeyword(Requestable.Molecules);
		
		getRelation(Requestable.MoleculeBasisStates)
			.addEnabledKeyword(Requestable.MoleculeStates);
		
		getRelation(Requestable.MoleculeQuantumNumbers)
			.addEnabledKeyword(Requestable.MoleculeStates);
		
		getRelation(Requestable.Processes)
			.addEnabledKeyword(Requestable.NonRadiativeTransitions)
			.addEnabledKeyword(Requestable.RadiativeTransitions)
			.addEnabledKeyword(Requestable.Collisions)
			.addEnabledKeyword(Requestable.RadiativeCrossSections)
			.setGrouping(true);
		getRelation(Requestable.Functions);
		getRelation(Requestable.Methods);
		getRelation(Requestable.Sources);
	}

	private KeywordRelation getRelation(Requestable relation){
		KeywordRelation result = keys.get(relation);
		if (result == null){
			result = new KeywordRelation(relation);
			keys.put(relation, result);
		}
		return result;
	}

	private class KeywordRelation{
		private Collection<KeywordRelation> enablingMe;
		private Collection<Requestable> enabledByMe;
		private Requestable key;
		private boolean isGrouping;

		KeywordRelation(Requestable key){
			this.enablingMe = new ArrayList<KeywordRelation>();
			this.enabledByMe = EnumSet.noneOf(Requestable.class);
			this.key = key;
			this.isGrouping = false;
		}

		public Collection<Requestable> getChildren() {
			EnumSet<Requestable> result = EnumSet.noneOf(Requestable.class);
			if (!isGrouping)
				for (KeywordRelation enabling:enablingMe)
					if (!enabling.isGrouping)
						result.add(enabling.key);
			if (isGrouping)
				result.addAll(enabledByMe);
			return result;
		}

		public KeywordRelation addEnabledKeyword(Requestable enabledKey){
			KeywordRelation relation = getRelation(enabledKey);
			return addEnabledKey(relation);
		}
		
		public KeywordRelation setGrouping(boolean flag){
			this.isGrouping = flag;
			return this;
		}
		
		private Requestable getKey(){
			return this.key;
		}

		private KeywordRelation addEnablingKey(KeywordRelation enablingKey){
			if (!this.enablingMe.contains(enablingKey)){
				this.enablingMe.add(enablingKey);
				enablingKey.addEnabledKey(this);
			}
			return this;
		}

		private KeywordRelation addEnabledKey(KeywordRelation enabledKey){
			if (!this.enabledByMe.contains(enabledKey.getKey())){
				this.enabledByMe.add(enabledKey.getKey());
				enabledKey.addEnablingKey(this);
			}
			return this;
		}

		public boolean isEnabled(Collection<Requestable> askedKeys){
			if (askedKeys.contains(key))
				return true;
			for (KeywordRelation child:enablingMe){
				if (child.isEnabled(askedKeys))
					return true;
			}
			return false;
		}
		
		public void normalize(Collection<Requestable> keys){
			if (keys.contains(key) || (isGrouping && keys.containsAll(enabledByMe))){
				keys.removeAll(enabledByMe);
				keys.add(getKey());
			}
		}
		
		public Collection<KeywordRelation> getEnablingMe(){
			return this.enablingMe;
		}
	}



}
