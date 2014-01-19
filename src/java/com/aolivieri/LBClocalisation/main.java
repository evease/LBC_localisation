package com.aolivieri.LBClocalisation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class main {
	public static void main(String[] args) throws SQLException, IOException {
		
		Les_annonces les_a = new Les_annonces("http://www.leboncoin.fr/locations/offres/poitou_charentes/deux_sevres/?");
		List<Annonce> les_annonces = les_a.recuperation_annonces();
		for (Annonce l_annonce : les_annonces) {
			System.out.println(l_annonce.toString());
		}
		}
		
	
}
