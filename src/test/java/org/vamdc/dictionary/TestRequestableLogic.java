package org.vamdc.dictionary;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.EnumSet;

import org.junit.Before;
import org.junit.Test;

public class TestRequestableLogic {
	
	private Collection<Requestable> keys;
	private RequestableLogic logic;
	
	@Before
	public void setupLogic(){
		logic = Factory.getRequestableLogic();
	}
	
	@Test
	public void testSpeciesEnableChildren(){
		keys = EnumSet.of(Requestable.Species);
		
		assertTrue(logic.isEnabled(keys, Requestable.Molecules));
		assertTrue(logic.isEnabled(keys, Requestable.Atoms));
		assertTrue(logic.isEnabled(keys, Requestable.Particles));
		assertTrue(logic.isEnabled(keys, Requestable.Solids));
		assertFalse(logic.isEnabled(keys, Requestable.AtomStates));
		assertFalse(logic.isEnabled(keys, Requestable.MoleculeQuantumNumbers));
	}
	
	@Test
	public void testEnableKeywordNormalize(){
		keys = EnumSet.of(Requestable.Atoms,Requestable.Molecules,Requestable.Particles);
		keys = logic.enableKey(keys, Requestable.Solids);
		assertTrue(keys.contains(Requestable.Species));
		assertTrue(keys.size()==1);
	}
	
	@Test
	public void testSpeciesEnabledByStates(){
		keys = EnumSet.of(Requestable.States);
		assertTrue(logic.isEnabled(keys, Requestable.Species));
	}
	
	@Test
	public void testDisableKeywordChild(){
		keys = EnumSet.of(Requestable.States);
		keys = logic.disableKey(keys, Requestable.AtomStates);
		assertTrue(keys.contains(Requestable.MoleculeStates));
		assertFalse(keys.contains(Requestable.AtomStates));
		assertTrue(keys.contains(Requestable.Species));
	}

	@Test
	public void testMolQNEnableMolecules(){
		keys = EnumSet.of(Requestable.MoleculeQuantumNumbers);
		assertTrue(logic.isEnabled(keys, Requestable.Molecules));
	}
	
	@Test
	public void testEmptyIsAll(){
		keys = EnumSet.noneOf(Requestable.class);
		for(Requestable key:Requestable.values()){
			assertTrue(logic.isEnabled(keys, key));
		}
	}
	
	@Test
	public void testDeleteOneFromAll(){
		keys = EnumSet.noneOf(Requestable.class);
		keys = logic.disableKey(keys, Requestable.MoleculeStates);
		assertTrue(logic.isEnabled(keys, Requestable.Molecules));
		assertTrue(logic.isEnabled(keys, Requestable.Atoms));
		assertFalse(logic.isEnabled(keys, Requestable.MoleculeQuantumNumbers));
	}
	
	@Test
	public void testGetChildren(){
		keys = logic.getLogicChildren(Requestable.Species);
		assertTrue(keys.contains(Requestable.Molecules));
		assertTrue(keys.contains(Requestable.Particles));
		assertTrue(keys.contains(Requestable.Atoms));
		assertFalse(keys.contains(Requestable.AtomStates));
		assertFalse(keys.contains(Requestable.States));
	}
	
}
