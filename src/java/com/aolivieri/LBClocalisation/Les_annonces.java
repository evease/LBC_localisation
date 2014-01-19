package com.aolivieri.LBClocalisation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Les_annonces {
	static String reponse;
	String doc_adresse;
	List<String> les_CP = new ArrayList<String>();
	List<Annonce> les_annonces = new ArrayList<Annonce>();
	
	public Les_annonces(String adresse) {
		super();
		this.reponse = null;
		this.doc_adresse = adresse;
	}


	public List<Annonce> recuperation_annonces() throws IOException {
		Document les_infos;
		this.les_CP.add("79270");
		this.les_CP.add("79460");
		this.les_CP.add("79410");
		this.les_CP.add("79230");
		this.les_CP.add("79180");
		this.les_CP.add("79000");
		
		//Parcours des CP sélectionnés
		for (String le_CP : this.les_CP) {
			
			//récupération du nombre de pages par CP
			int last_page = nombre_pages(le_CP);	
			System.out.println(le_CP + "-> " + last_page);
			
			//Récupération des annonces de toutes les pages
			for (int i = 1; i < last_page+1; i++) {
				
				les_infos = Jsoup.connect(this.doc_adresse+"location=Toutes%20les%20communes%20"+ le_CP+"&o="+i).get();
				Elements les_elements = les_infos.select("div.list-lbc > a");
				
				if(les_elements.isEmpty() == false){
					
					for (Element l_element : les_elements) {
						this.les_annonces.add(new Annonce(l_element.select(".title").html(), l_element.select(".date > div").html(),l_element.attr("href"),l_element.select(".placement").html(), l_element.select(".image-and-nb").html()));
					}
				}
			}
		}
		return this.les_annonces;
	}
	
	public int nombre_pages(String le_CP) throws IOException{
		Document la_page;
		int last_page;
		la_page = Jsoup.connect(this.doc_adresse+"location=Toutes%20les%20communes%20"+ le_CP).get();
		
		//récupération du lien de la dernière page
		Element nb_page = la_page.select("li a").last();
		String str = nb_page.attr("href");
		
		//S'il n'y a pas de liens
		if(str.indexOf("?o=")!=-1){
			int deb = str.indexOf("?o=")+3;
			int fin = str.indexOf("&location");
			last_page = Integer.parseInt(str.substring(deb, fin));
		}else{
			last_page = 1;
		}
			
		return last_page;
	}

}
