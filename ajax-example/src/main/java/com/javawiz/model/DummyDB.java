package com.javawiz.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.stereotype.Service;
@Service 
public class DummyDB {
    private List<String> countries;
    private List<String> technologies;
    private List<Tag> tags;
    
    public DummyDB() {

    	String country = "Afghanistan,	Albania, Algeria, Andorra, Angola, Antigua & Deps,"+ 
    			"Argentina,	Armenia, Australia,	Austria,Azerbaijan,Bahamas,Bahrain,Bangladesh,Barbados,"+ 
    			"Belarus,Belgium,Belize,Benin,Bhutan,Bolivia,Bosnia Herzegovina,Botswana,Brazil,Brunei,"+ 
    			"Bulgaria,Burkina,Burundi,Cambodia,Cameroon,Canada,Cape Verde,Central African Rep,Chad,"+ 
    			"Chile,China,Colombia,Comoros,Congo,Congo {Democratic Rep},Costa Rica,Croatia,Cuba,Cyprus,"+ 
    			"Czech Republic,Denmark,Djibouti,Dominica,Dominican Republic,East Timor,Ecuador,Egypt,El Salvador,"+ 
    			"Equatorial Guinea,	Eritrea,Estonia,Ethiopia,Fiji,Finland,France,Gabon,Gambia,Georgia,Germany,"+ 
    			"Ghana,	Greece,	Grenada,Guatemala,Guinea,Guinea-Bissau,Guyana,Haiti,Honduras,Hungary,Iceland,"+ 
    			"India,	Indonesia,Iran,Iraq,Ireland {Republic},Israel,Italy,Ivory Coast,Jamaica,Japan,"+ 
    			"Jordan,Kazakhstan,Kenya,Kiribati,Korea North,Korea South,Kosovo,Kuwait,Kyrgyzstan,Laos,"+ 
    			"Latvia,Lebanon,Lesotho,Liberia,Libya,Liechtenstein,Lithuania,Luxembourg,Macedonia,Madagascar,"+ 
    			"Malawi,Malaysia,Maldives,Mali,Malta,Marshall Islands,Mauritania,Mauritius,Mexico,Micronesia,"+ 
    			"Moldova,Monaco,Mongolia,Montenegro,Morocco,Mozambique,Myanmar {Burma},Namibia,Nauru,Nepal,"+ 
    			"Netherlands,New Zealand,Nicaragua,Niger,Nigeria,Norway,Oman,Pakistan,Palau,Panama,Papua New Guinea,"+ 
    			"Paraguay,Peru,Philippines,Poland,Portugal,Qatar,Romania,Russian Federation,Rwanda,St Kitts & Nevis,"+
    			"St Lucia,Saint Vincent & the Grenadines,Samoa,San Marino,Sao Tome & Principe,Saudi Arabia,Senegal,"+ 
    			"Serbia,Seychelles,Sierra Leone,Singapore,Slovakia,Slovenia,Solomon Islands,Somalia,South Africa,"+ 
    			"Spain,Sri Lanka,Sudan,Suriname,Swaziland,Sweden,Switzerland,Syria,Taiwan,Tajikistan,Tanzania, "+
    			"Thailand,Togo,Tonga,Trinidad & Tobago,Tunisia,Turkey,Turkmenistan,Tuvalu,Uganda,Ukraine,United Arab Emirates,"+
    			"United Kingdom,United States,Uruguay,Uzbekistan,Vanuatu,Vatican City,Venezuela,Vietnam,Yemen,Zambia,Zimbabwe";

    	countries = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(country, ",");
        
        //Parse the country CSV list and set as Array
        while(st.hasMoreTokens()) {
            countries.add(st.nextToken().trim());
        }

        String strTags = "SharePoint, Spring, Struts, Java, JQuery, ASP, PHP, JavaScript, MySQL, .NET, ruby, rails, c / c++, python";
        technologies = new ArrayList<String>();
        StringTokenizer st2 = new StringTokenizer(strTags, ",");
        
        //Parse the tags CSV list and set as Array
        while(st2.hasMoreTokens()) {
        	technologies.add(st2.nextToken().trim());
        }
        
        tags= new ArrayList<Tag>();
		tags.add(new Tag(1, "ruby"));
		tags.add(new Tag(2, "rails"));
		tags.add(new Tag(3, "c / c++"));
		tags.add(new Tag(4, ".net"));
		tags.add(new Tag(5, "python"));
		tags.add(new Tag(6, "java"));
		tags.add(new Tag(7, "javascript"));
		tags.add(new Tag(8, "jscript"));
    }
 
    public List<String> getCountryList(String query) {
            	
    	String country = null;
        query = query.toLowerCase();
        List<String> matched = new ArrayList<String>();
        for(int i=0; i < countries.size(); i++) {
            country = countries.get(i).toLowerCase();
            if(country.startsWith(query)) {
                matched.add(countries.get(i));
            }
        }
        return matched;
    }

    public List<String> getTechList(String query) {
        String tech = null;
        query = query.toLowerCase();
        List<String> matched = new ArrayList<String>();
        for(int i=0; i < technologies.size(); i++) {
            tech = technologies.get(i).toLowerCase();
            if(tech.startsWith(query)) {
                matched.add(technologies.get(i));
            }
        }
        return matched;
    }
    
    public List<Tag> simulateSearchResult(String tagName) {

		List<Tag> result = new ArrayList<Tag>();

		// iterate a list and filter by tagName
		for (Tag tag : tags) {
			if (tag.getTagName().contains(tagName)) {
				result.add(tag);
			}
		}
		return result;
	}
}