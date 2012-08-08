package org.vamdc.dictionary;

public enum IAEAProcessCode {
	EAS("Angular Scattering",""),
	EBS("Bremsstrahlung","e+A \rightarrow e+A+h\nu"),
	EDX("Deexcitation","e+A^* \rightarrow e+A"),
	EEL("Elastic Scattering","e+A \rightarrow e+A"),
	ELB("Line Broadening, Shapes and Shifts",""),
	ETS("Total Scattering",""),
	EDT("Detachment","e+A^- \rightarrow A+2e"),
	EFL("Fluorescence",""),
	EEX("Excitation, Change of Excitation","e+A \rightarrow e+A^*"),
	EIN("Ionization","e+A \rightarrow e+A^++e"),
	EMI("Multiple Ionization","e+A \rightarrow A^{+n}+(n+1)e"),
	ENI("Negative Ion Formation","e+A \rightarrow A^-"),
	EMT("Momentum Transfer, Transport CS's (momentum,...)",""),
	EUP("Unknown Products",""),
	EDP("Depolarization, Change of Polarization",""),
	EIP("Creation of an ion pair (positive-negative)","e+AB^+ \rightarrow A^-+B^-"),

	ERC("Recombination (general)","A^{+q}+e \rightarrow A^{+(q-1)}"),
	ERR("Radiative Recombination","e+A^+ \rightarrow A+h\nu"),
	ERD("Dielectronic Recombination","e+A^+ \rightarrow A^{**} \rightarrow A^*+h\nu+e"),
	ERT("3-body Recombination","e+e+A^+ \rightarrow A+e"),
	ERO("e-i-o Recombination","e+A^++B \rightarrow A+B"),
	EDC("Dielectronic Capture","e+A^+ \rightarrow A^{**}"),
	EDS("Dissociation","e+AB \rightarrow e+A+B"),
	EDR("Dissociative Recombination","e+AB^+ \rightarrow A+B"),
	EDA("Dissociative Attachment","e+AB \rightarrow A+B^-"),
	EDE("Dissociative Excitation","e+AB \rightarrow A^*+B+e"),
	EDI("Dissociative Ionization","e+AB \rightarrow A^++B+2e"),

	PTS("Total Absorption, Scattering",""),
	PDS("Photodissociation","h\nu+AB \rightarrow A+B"),
	PES("Elastic Scattering","h\nu+A \rightarrow h\rightarrow+A"),
	PMA("Multiphoton Absorption (excitation and ionization)","nh\nu+A \rightarrow A^*(A^+)"),
	PDT("Photodetachment","A+B \rightarrow AB+h\nu"),
	PFL("Fluorescence",""),
	PEX("Photoexcitation","h\nu+A \rightarrow A^*"),
	PIN("Photoionization","h\nu+A \rightarrow A^++e"),
	PFF("Free-Free Absorption or Inverse Bremsstrahlung","h\nu+e+A \rightarrow e+A"),
	PEA("Effective Absorption, Total Diffusion",""),
	PTA("True Absorption",""),
	PAD("Angular Diffusion (scattering)",""),
	PED("Elastic Diffusion (Thomson, Rayleigh)",""),
	PNL("Non-linear Effects",""),
	PLE("Emission of Line",""),
	PZE("Zeeman Effect",""),
	PSE("Stark Effect",""),
	PGF("General Electromagnetic Field",""),
	PTF("Interaction with Time-Varying Fields",""),


	HAS("Association - Heavy Particle","A+B \rightarrow AB"),
	HLB("Line Broadening, Shapes and Shifts - Heavy Particle",""),
	HDS("Dissociation - Heavy Particle","A+BC \rightarrow A+B+C"),
	HDX("Deexcitation - Heavy Particle","A^*+B \rightarrow A+B"),
	HES("Elastic Scattering - Heavy Particle","A+B \rightarrow A+B"),
	HCX("Charge Transfer - Heavy Particle","A^++B \rightarrow A+B^+,A^-+B \rightarrow A+B^-"),
	HUP("Unknown Products - Heavy Particle",""),
	//HAS("Angular Scattering - Heavy Particle",""),
	HIR("Interchange Reactions - Heavy Particle","A+BC \rightarrow AB+C"),
	HEL("Inelastic Energy Losses - Heavy Particle",""),
	HET("Energy Transfer - Heavy Particle",""),
	HIP("Interaction Potentials - Heavy Particle",""),
	HRC("Recombination - Heavy Particle",""),
	HTS("Total Scattering - Heavy Particle",""),
	HDT("Detachment - Heavy Particle","A+B^- \rightarrow A+B+e"),
	HFL("Fluorescence - Heavy Particle",""),
	HEX("Excitation - Heavy Particle","A+B \rightarrow A^*+B"),
	HIN("Ionization - Heavy Particle","A+B \rightarrow A+B^++e"),
	HPN("Penning Ionization - Heavy Particle","A^*+B \rightarrow A+B^++e"),
	HST("Stripping (of projectile) - Heavy Particle","A+B \rightarrow A^++B+e"),
	HAT("Attenuation - Heavy Particle",""),
	HXT("Excitation Transfer - Heavy Particle","A^*+B \rightarrow A+B*"),
	HAI("Associative Interchange Reactions - Heavy Particle",""),
	HDI("Dissociative Interchange Reactions - Heavy Particle",""),
	HDC("Dissociative Charge Transfer - Heavy Particle","A^++BC \rightarrow A+B^++C"),
	HMN("Mutual Ion-Ion Neutralization - Heavy Particle","A^++B^- \rightarrow A+B"),
	
	
	;
	
	private final String name;
	private final String description;
	
	IAEAProcessCode(String name, String description){
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
