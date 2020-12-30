package com.example;

import java.util.ArrayList;
import java.util.List;

public class MoneyParts {
	public final double denomination[] = {200,100,50,20,10,5,2, 1, 0.5, 0.2, 0.1, 0.05 };

	private List<Double> list = new ArrayList<>();

	public void build(double customerAmount, int i) {
		if (this.validateLowerDenomination(customerAmount)) {
			combinations(customerAmount, i);
		}
	}

	public void combinations(double customerAmount, int i) {
		if (i == denomination.length)
			return;
		
		if(customerAmount >= denomination[i]) {
			for (double j = customerAmount / denomination[i]; j > 0; j--) {
				if(j - (long)j == 0) {
					list.add(denomination[i]);
				}				
			}
			showList();
			if (i != denomination.length) {
				combinations(customerAmount, i + 1);
			}
		}else {
			combinations(customerAmount, i + 1);
		}
	}

	public boolean validateLowerDenomination(double customerAmount) {
		if (customerAmount < denomination[denomination.length - 1]) {
			System.out.println(
					"[Denominación Errónea]-> Monto mínimo permitido: " + denomination[denomination.length - 1]);
			return false;
		}
		return true;
	}

	public void showList() {
		list.stream().forEach((p) -> System.out.print(" "+ p));
		list.clear();
		System.out.println();
	}

	public static void main(String args[]) {
		MoneyParts cajero = new MoneyParts();
		cajero.build(200, 0);
	}
}
