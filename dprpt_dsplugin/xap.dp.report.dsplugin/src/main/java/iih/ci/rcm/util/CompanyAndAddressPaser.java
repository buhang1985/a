package iih.ci.rcm.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import xap.mw.log.logging.Logger;

/**
 * 解析工作单位及地址的工具类
 * @author F
 *
 */
public class CompanyAndAddressPaser {
	static final String reg = "[\u4e00-\u9fa5]";
	static final Pattern ms_Pattern_point = Pattern.compile(reg + "+?(?:集团(.*)公司|公司|计算所|研究所|院|集团)");
	static final Splitter ms_splitter_company = new Splitter(ms_Pattern_point, new Pattern[] { ms_Pattern_point });
	static final Splitter[] ms_defaultsplitters = new Splitter[] {ms_splitter_company};


	private static LinkedHashMap<Integer, Splitter> split(String src, Splitter[] splitters) {
		LinkedHashMap<Integer, Splitter> splitterdic = new LinkedHashMap<Integer, Splitter>();
		for (Splitter s : splitters) {
			Matcher m = s.pattern.matcher(src);
			while (m.find()) {
				splitterdic.put(m.start() + m.group().length(), s);
				if (s.flag) {
					break;
				}
			}
		}
		return splitterdic;
	}

	private static Segment segmentRecognize(String src, Pattern r) {
		Matcher m = r.matcher(src);
		if (m.matches()) {
			return new Segment(m.group(), r);
		} else {
			return null;
		}
	}

	private static ArrayList<Segment> recognize(String src, LinkedHashMap<Integer, Splitter> splitterdic) {
		Segment s;
		int index = 0;
		ArrayList<Segment> segments = new ArrayList<Segment>();
		if (src.length() > 0) {
			for (Integer key : splitterdic.keySet()) {
				Splitter value = splitterdic.get(key);
				if (key > index && key < src.length()) {
					for (Pattern r : value.patterns) {
						s = segmentRecognize(src.substring(index, key), r);
						if (s != null) {
							segments.add(s);
							break;
						}
					}
					index = key;
				}
			}
		}
		return segments;
	}

	public static CompanyAndAddressBean parse(String source) {
		CompanyAndAddressBean caa = new CompanyAndAddressBean();

		try {
			String tmpsource=source+"address";
			tmpsource = tmpsource.replace(".", "").replace("，", "").replace(",", "").replace(" ", "");	
			ArrayList<Segment> segments = recognize(tmpsource, split(tmpsource, ms_defaultsplitters));

			String company = segmentsGetStringForPattern(segments, ms_Pattern_point);
			if(company!=null){
				String address = source.substring(company.length(), source.length());
				caa.setAddress(address);
				caa.setCompany(company);
			}else{
				caa.setAddress(source);
				caa.setCompany(source);
			}
		} catch (Exception e) {
			Logger.error("*****病案首页插入中间表报错*****工作地址解析报错("+source+")：",e);
			// e.printStackTrace();
		}

		return caa;

	}

	private static String segmentsGetStringForPattern(ArrayList<Segment> segments, Pattern r) {
		for (Iterator<Segment> it = segments.iterator(); it.hasNext();) {
			Segment s = it.next();
			if (s.pattern == r) {
				return s.value;
			}
		}
		return null;
	}
}
