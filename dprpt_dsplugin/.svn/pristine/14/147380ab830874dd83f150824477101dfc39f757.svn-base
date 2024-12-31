package iih.ci.rcm.util;

import java.util.List;

public class ChineseAddress {
	public String source="";
    public String nation="";
    public String province="";
    public String city="";
    public String county="";
    public String street="";
    public List<String> roads;
    public String number="";
    public String plaza="";
    public String ip="";
    public String town="";
    public String village="";
    public String zone="";
    public String underground="";
    public List<String> notes;
    public List<String> noises;
    public String workfor="";
    public String work_address="";
    private static final String SEPARATOR = System.getProperty("line.separator");
 
    public String toString() {
        String s = "src：        " + source + SEPARATOR;
        if (nation != null) {
            s = s + "nati：  " + nation + SEPARATOR;
        }
        if (province != null) {
            s = s + "prov:  " + province + SEPARATOR;
        }
        if (city != null) {
            s = s + "city:  " + city + SEPARATOR;
        }
        if (county != null) {
            s = s + "coun:  " + county + SEPARATOR;
        }
        if (street != null) {
            s = s + "street： " + street + SEPARATOR;
        }
        if (number != null) {
            s = s + "numb：  " + number + SEPARATOR;
        }
        if (plaza != null) {
            s = s + "plaza: " + plaza + SEPARATOR;
        }
        if (ip != null) {
            s = s + "idp:   " + ip + SEPARATOR;
        }
        if (town != null) {
            s = s + "town:   " + town + SEPARATOR;
        }
        if (village != null) {
            s = s + "vill:   " + village + SEPARATOR;
        }
        if (zone != null) {
            s = s + "zone:  " + zone + SEPARATOR;
        }
        if (underground != null) {
            s = s + "under:   " + underground + SEPARATOR;
        }
        if (roads != null) {
            s = s + "road:  ";
            for (int i = 0; i < roads.size(); i++) {
                String r = roads.get(i);
                if (r == roads.get(0)) {
                    s = s + r;
                } else {
                    s = s + " / " + r;
                }
            }
            s = s + SEPARATOR;
        }
        if (notes != null) {
            s = s + "not: ";
            for (int i = 0; i < notes.size(); i++) {
                String n = notes.get(i);
                if (n == roads.get(0)) {
                    s = s + n;
                } else {
                    s = s + " / " + n;
                }
            }
            s = s + SEPARATOR;
        }
        if (noises != null) {
            s = s + "noi: ";
            for (int i = 0; i < noises.size(); i++) {
                s = s + noises.get(i) + " / ";
            }
            s = s + SEPARATOR;
        }
       if (workfor != null) {
    	   s = s + "workfor: " + workfor + SEPARATOR;
       }
       if (work_address != null) {
    	   s = s + "workfor_address: " + work_address + SEPARATOR;
       }
        return s;
    }
}
