package com.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeChecker {

	public CodeChecker() {

	}
	
	
	public List<String> report(String snippet) {

		List<String> report = new ArrayList<String>();
		HashMap<String, String> v = vulnerabilityMap();
		List<String> submittedCode = snippetReader(snippet);


		for (String code : submittedCode) {
			for (String vulnerability : v.keySet()) {
				if (code.contains(vulnerability)) {
					String value = v.get(vulnerability);
					report.add("Vulnerabilty found at "+code +"\nKnown vulnerability flagged: "+ vulnerability+"\nRecomendation: "+ value +"\n");
				}			
			}
		}
		return report;

	}

	public List<String> snippetReader(String snippet) {

		List<String> snippets = Arrays.asList(snippet.split("\\r?\\n"));
		List<String> items = new ArrayList<>();
		int count = 1;
		for (String item : snippets) {
			items.add("Line " + count++ + " : " + item);
		}
		return items;
	}

	public HashMap<String, String> vulnerabilityMap() {

		HashMap<String, String> vulernabilities = new HashMap<String, String>();

		vulernabilities.put("System.out.println", "Use Logger.* instead.");
		vulernabilities.put("createStatement", " Use prepareStatement instead.");
		vulernabilities.put("sendRedirect", "Use safeSendRedirect instead.");
		vulernabilities.put("Math.Random", " Use Randomizer instead.");
		vulernabilities.put("isSecure", "Use HTTPUtilties.isSecureChannel() instead.");
		vulernabilities.put("javax.crypto", "Use encrpytor instead");
		return vulernabilities;
	}

}
