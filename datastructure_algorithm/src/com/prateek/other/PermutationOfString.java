package com.prateek.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationOfString {

	List<String> permutationString = new ArrayList<>();

	List<String> permutation(String s) {
		if (s.length() == 1) {
			permutationString.add(s);
		} else {
			char c = s.charAt(s.length() - 1);
			s = s.substring(0, s.length() - 1);
			permutationString = merege(permutation(s), c);

		}
		return permutationString;
	}

	List<String> merege(List<String> permutationString, char c) {

		List<String> result = new ArrayList<>();
		for (String s : permutationString) {
			for (int i = 0; i <=s.length(); i++) {
				StringBuffer sf = new StringBuffer().append(s).insert(i, c);
				result.add(sf.toString());
			}
		}
		return result;
	}

	public static void main(String[] args) {

		PermutationOfString ps = new PermutationOfString();
		List<String> result = ps.permutation("3bcD");
		Collections.sort(result);
		for (String s : result) {
			System.out.println(s);
		}

	}

}
