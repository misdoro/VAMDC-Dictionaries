package org.vamdc.dictionary;

/**
 * Enumeration of XSAMS process codes, as defined in XSAMS 1.0,
 * providing verbose names and descriptions
 */
public enum XsamsProcessCode {

		phem("Photon emission","Emission of a photon or photons " +
		"from a reactant (e.g.,. atom, molecule, surface), fluorescence"),
		phab("Photon absorption","Absorption of a photon or photons " +
		"from a reactant (e.g., atom, molecule, surface)"),
		phsc("Photon scattering","Scattering of a photon or photons by a reactant"),
		elas("Elastic scattering","Scattering of one reactant from another without " +
		"change of state or energy, including related " +
		"processes such as momentum transfer"),
		inel("Inelastic scattering","Scattering of one reactant from another with " +
		"change of state or energy. This code is provided " +
		"in case none of the other specific inelastic codes " +
		"are applicable or appropriate (e.g., energy or spin " +
		"transfer reactions, projectile energy loss)"),
		exci("Excitation","Excitation from a lower to higher state of any" +
		" fundamental reactant, e.g., electron-impact" +
		" excitation of an atom, photoexcitation of a" +
		" molecule to a higher ro-vibrational state"),
		deex("De-excitation","Induced or spontaneous transition from a higher" +
		" state to a lower state, e.g., vibrational" +
		" de-excitation in atom-diatom scattering"),
		ioni("Ionization","Removal of an electron from any reactant"),
		tran("Charge transfer","Transfer of an electron from one \"center\"" +
		" (atomic ion, atom, molecule, etc.) to another"),
		exch("Electron exchange","The exchange of an electron with another electron" +
		" (most commonly in electron-impact processes)"),
		reco("Recombination"," Capture of an electron by an atomic or molecular ion," +
		" e.g., in dissociative recombination, dielectronic recombination," +
		" or radiative recombination"),
		elat("Electron attachment","The formation of a negative ion by electron" +
		" attachment"),
		eldt("Electron detachment","The removal of the weakly bound electron of a" +
		" negative ion by photon impact or collision with" +
		" another particle such as an electron or surface"),
		asso("Association","Association of two (or more) reactants, typically" +
		" neutrals, collisionally, or radiatively"),
		diss("Dissociation"," The splitting of two (or more) reactants" +
		" e.g., via electron-impact of a molecule," +
		" photodissociation, molecular break-up on a surface"),
		intr("Interchange","The exchange of a heavy particle (atom, ion)" +
		" in a reaction"),
		chem("Chemical reaction","The exchange of atoms or groups of atoms" +
		" in chemical reactions,"),
		sore("Reflection","The elastic or inelastic reflection of a reactant from a surface"),
		soem("Emission or erosion","Any form of erosion of a surface," +
		" e.g., physical or chemical sputtering, etching, " +
		" sublimation, emission of particle or" +
		" macroscopic pieces, desorption, secondary electron emission"),
		sodp("Deposition","Absorption of particles by a surface, sticking, surface implantation"),
		soch("Change","Change of the composition or properties of a surface induced by any reactant"),
		sope("Penetration","The penetration of a reactant into a solid, characterized by the" +
		" change of energy, e.g., stopping, straggling, energy loss, range," +
		" charge state equilibrium, or" +
		" change of  structure, e.g., trapping, diffusion, deep implantation"),
		rota("Rotational process","Characterizes processes involving transition between rotational states"),
		vibr("Vibrational process","Characterizes processes involving transition between vibrational states"),
		rvib("Ro-Vibrational process","Characterizes processes involving transition between ro-vibrational states"),
		hype("Hyperfine process","Characterizes processes involving transition between hyperfine states"),
		hyp1("Hyperfine 1 process","Characterizes processes involving transition between hyperfine states" +
				"when 1 nuclear spin coupling is resolved"),
		hyp2("Hyperfine 2 process","Characterizes processes involving transition between hyperfine states" +
				"when 2 nuclear spin couplings are resolved"),
		hyp3("Hyperfine 3 process","Characterizes processes involving transition between hyperfine states" +
				"when 3 nuclear spin couplings are resolved"),
		hyp4("Hyperfine 4 process","Characterizes processes involving transition between hyperfine states" +
				"when 4 nuclear spin couplings are resolved"),
		hyp5("Hyperfine 5 process","Characterizes processes involving transition between hyperfine states" +
				"when 5 nuclear spin couplings are resolved"),
		hyp6("Hyperfine 6 process","Characterizes processes involving transition between hyperfine states" +
				"when 6 nuclear spin couplings are resolved"),
		hyp7("Hyperfine 7 process","Characterizes processes involving transition between hyperfine states" +
				"when 7 nuclear spin couplings are resolved"),
		hyp8("Hyperfine 8 process","Characterizes processes involving transition between hyperfine states" +
				"when 8 nuclear spin couplings are resolved"),
		hyp9("Hyperfine 9 process","Characterizes processes involving transition between hyperfine states" +
				"when 9 nuclear spin couplings are resolved"),
		fine("Fine process","Characterizes processes involving transition between fine states"),
		tors("Torsional process","Characterizes processes involving transition between torsional states"),
		rtor("Ro-Torsional process","Characterizes processes involving transition between ro-torsional states"),
	;	
	
		
	private final String name;
	private final String description;
	
	XsamsProcessCode(String name, String description){
		this.name=name;
		this.description=description;
	}
		
	public String getProcessName(){
		return this.name;
	}
	
	public String getDescription(){
		return this.description;
	}

}
