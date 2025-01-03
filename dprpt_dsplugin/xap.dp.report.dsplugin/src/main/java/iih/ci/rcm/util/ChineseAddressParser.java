package iih.ci.rcm.util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import xap.mw.log.logging.Logger;

/**
 * 解析普通地址的工具类
 * @author F
 *
 */
public class ChineseAddressParser {
	static final String reg = "[\u4e00-\u9fa5]";
    static final Pattern ms_Pattern_guo = Pattern.compile("中国");
    static final Pattern ms_Pattern_jinjiao = Pattern.compile("近郊");
    static final Pattern ms_Pattern_sheng = Pattern.compile(reg + "+?省");
    static final Pattern ms_Pattern_shi = Pattern.compile(reg + "+?市(?!场)");
    static final Pattern ms_Pattern_qu = Pattern.compile(reg + "+?区");
    static final Pattern ms_Pattern_xiang = Pattern.compile(reg + "+?乡");
    static final Pattern ms_Pattern_xian = Pattern.compile(reg + "+?县");
    static final Pattern ms_Pattern_hutong = Pattern.compile(reg + "+?胡同");
    static final Pattern ms_Pattern_nongtang = Pattern.compile(reg + "+?弄堂");
    static final Pattern ms_Pattern_jie = Pattern.compile(reg + "+?街");
    static final Pattern ms_Pattern_xiangg = Pattern.compile(reg + "+?巷");
    static final Pattern ms_Pattern_lu = Pattern.compile(reg + "+?路");
    static final Pattern ms_Pattern_cun = Pattern.compile(reg + "+?村");
    static final Pattern ms_Pattern_zhen = Pattern.compile(reg + "+?镇");
    static final Pattern ms_Pattern_hao = Pattern.compile("[甲_乙_丙_0-9_-]+?号");
    static final Pattern ms_Pattern_point = Pattern.compile(reg + "+?(?:广场|酒店|饭店|宾馆|中心|大厦|百货|大楼|商城)");
    static final Pattern ms_Pattern_ditie = Pattern.compile("地铁" + reg + "+?线(?:" + reg + "+?站)?");
    static final Pattern ms_Pattern_province = Pattern.compile(reg + "{2,10}?(?:省|特区|自治区|特别行政区|澳门|香港|台湾|外籍)");
    static final Pattern ms_Pattern_city = Pattern.compile(reg + "+?(?:市|地区|自治州)");
    static final Pattern ms_Pattern_county = Pattern.compile(reg + "+?县");
    static final Pattern ms_Pattern_street = Pattern.compile(reg + "+?办事处|街道");
    static final Pattern ms_Pattern_road = Pattern.compile(reg + "+?(?:胡同|弄堂|街|巷|路|道)");
    static final Pattern ms_Pattern_roadnear = Pattern.compile("(?<=近)" + reg + "+?(?:胡同|弄堂|街|巷|路|道)");
    static final Pattern ms_Pattern_ip = Pattern.compile(reg + "+?(?:开发区|科技区|园区)");
    static final Pattern ms_Pattern_zone = Pattern.compile(reg + "+?(?:小区|社区|新村)");
    static final Pattern ms_Pattern_village = Pattern.compile(reg + "+?村");
    static final Pattern ms_Pattern_town = Pattern.compile(reg + "+?(?:乡|镇|地区)");
    static final Pattern ms_Pattern_number = Pattern.compile("[甲_乙_丙_0-9_-]+号");
    static final Pattern ms_Pattern_plaza = Pattern.compile(reg + "+?(?:广场|酒店|饭店|宾馆|中心|大厦|百货|大楼|商城)");
    static final Pattern ms_Pattern_underground = Pattern.compile("地铁" + reg + "+?线(?:" + reg + "+?站)?");
    
    static final Splitter ms_splitter_guo = new Splitter(ms_Pattern_guo, new Pattern[]{ms_Pattern_guo});
    static final Splitter ms_splitter_province = new Splitter(ms_Pattern_province, new Pattern[]{ms_Pattern_province});
    static final Splitter ms_splitter_city = new Splitter(ms_Pattern_city, new Pattern[]{ms_Pattern_city});
    static final Splitter ms_splitter_shi = new Splitter(ms_Pattern_shi, new Pattern[]{ms_Pattern_city}, false);
    static final Splitter ms_splitter_jinjiao = new Splitter(ms_Pattern_jinjiao, new Pattern[]{ms_Pattern_jinjiao});
    static final Splitter ms_splitter_qu = new Splitter(ms_Pattern_qu, new Pattern[]{ms_Pattern_province, ms_Pattern_city, ms_Pattern_zone, ms_Pattern_ip, ms_Pattern_qu}, false);
    //static final Splitter ms_splitter_country = new Splitter(ms_Pattern_county, new Pattern[]{ms_Pattern_county});
    //static final Splitter ms_splitter_xiang = new Splitter(ms_Pattern_xiang, new Pattern[]{ms_Pattern_county});
    static final Splitter ms_splitter_xiang = new Splitter(ms_Pattern_xiang, new Pattern[]{ms_Pattern_xiang});
    static final Splitter ms_splitter_xian = new Splitter(ms_Pattern_xian, new Pattern[]{ms_Pattern_county});
    static final Splitter ms_splitter_dao = new Splitter(ms_Pattern_street, new Pattern[]{ms_Pattern_street, ms_Pattern_roadnear, ms_Pattern_road}, false);
    static final Splitter ms_splitter_hutong = new Splitter(ms_Pattern_hutong, new Pattern[]{ms_Pattern_roadnear, ms_Pattern_road}, false);
    static final Splitter ms_splitter_nongtang = new Splitter(ms_Pattern_nongtang, new Pattern[]{ms_Pattern_roadnear, ms_Pattern_road}, false);
    static final Splitter ms_splitter_jie = new Splitter(ms_Pattern_jie, new Pattern[]{ms_Pattern_road}, false);
    static final Splitter ms_splitter_lu = new Splitter(ms_Pattern_lu, new Pattern[]{ms_Pattern_roadnear, ms_Pattern_road}, false);
    static final Splitter ms_splitter_xiangg = new Splitter(ms_Pattern_xiangg, new Pattern[]{ms_Pattern_roadnear, ms_Pattern_road}, false);
    static final Splitter ms_splitter_cun = new Splitter(ms_Pattern_cun, new Pattern[]{ms_Pattern_zone, ms_Pattern_village});
    static final Splitter ms_splitter_zhen = new Splitter(ms_Pattern_zhen, new Pattern[]{ms_Pattern_town});
    static final Splitter ms_splitter_hao = new Splitter(ms_Pattern_hao, new Pattern[]{ms_Pattern_number});
    static final Splitter ms_splitter_point = new Splitter(ms_Pattern_point, new Pattern[]{ms_Pattern_plaza});
    static final Splitter ms_splitter_ditie = new Splitter(ms_Pattern_ditie, new Pattern[]{ms_Pattern_underground});
    
    static final Pattern ms_Pattern_axtw = Pattern.compile("(澳门|香港|台湾|外籍)");
    static final Splitter ms_splitter_axtw = new Splitter(ms_Pattern_axtw, new Pattern[]{ms_Pattern_axtw});

    static final Splitter[] ms_defaultsplitters = new Splitter[]{
		ms_splitter_guo,
		ms_splitter_province,
		ms_splitter_city,
		ms_splitter_shi,
		ms_splitter_qu,
		ms_splitter_axtw,
		//ms_splitter_country,
		ms_splitter_xian,
		ms_splitter_zhen,
		ms_splitter_dao,
		ms_splitter_cun,
		ms_splitter_xiang,
		ms_splitter_jie,
		ms_splitter_hutong,
		ms_splitter_nongtang,
		ms_splitter_xiangg,
		ms_splitter_lu,
		ms_splitter_hao,
		ms_splitter_point,
		ms_splitter_ditie,
		ms_splitter_jinjiao,
    };
 
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
 
    private static Segment segmentRecognize(String src, Pattern r) {
        Matcher m = r.matcher(src);
        if (m.matches()) {
            return new Segment(m.group(), r);
        } else {
            return null;
        }
    }
 
    private static ArrayList<String> segmentsGetStringListForPattern(ArrayList<Segment> segments, Pattern r) {
        ArrayList<String> ss = new ArrayList<String>();
        for (Iterator<Segment> it = segments.iterator(); it.hasNext();) {
            Segment s = it.next();
            if (s.pattern == r) {
                ss.add(s.value);
            }
        }
        return ss;
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
 
    public static ChineseAddress parse(String source) {
    	ChineseAddress ca = new ChineseAddress();
    	try {
			String tmpsource=source+"address";
			tmpsource = tmpsource.replace(".", "").replace("，", "").replace(",", "").replace(" ", "").replace("市辖区", "");
			ArrayList<Segment> segments = recognize(tmpsource, split(tmpsource, ms_defaultsplitters));
			
			ca.source = source;
 
			ca.nation = segmentsGetStringForPattern(segments, ms_Pattern_guo);
   
			String str=segmentsGetStringForPattern(segments, ms_Pattern_axtw);
			if(str!=null && str.length()>0){
			    ca.province = segmentsGetStringForPattern(segments, ms_Pattern_axtw);
			}else{
				ca.province = segmentsGetStringForPattern(segments, ms_Pattern_province);
			}
			ca.city = segmentsGetStringForPattern(segments, ms_Pattern_city);
			ca.county = segmentsGetStringForPattern(segments, ms_Pattern_county);
			boolean flag = segmentsGetStringForPattern(segments, ms_Pattern_qu) != null && segmentsGetStringForPattern(segments, ms_Pattern_qu).length() > 0 ;
			ca.county = flag ? segmentsGetStringForPattern(segments, ms_Pattern_qu) :segmentsGetStringForPattern(segments, ms_Pattern_county);
			// 修改第四级地址的获取方式
			String street = segmentsGetStringForPattern(segments, ms_Pattern_street);
			if (street != null && street.length() > 0) {
				ca.town = street;
			} else {
				String town = segmentsGetStringForPattern(segments, ms_Pattern_town);
				if (town != null && town.length() > 0) {
					ca.town = town;
				} else {
					String zone = segmentsGetStringForPattern(segments, ms_Pattern_zone);
					if (zone != null && zone.length() > 0) {
						ca.town = zone;
					} else {
						String xiang = segmentsGetStringForPattern(segments, ms_Pattern_xiang);
						if (xiang != null && xiang.length() > 0) {
							ca.town = xiang;
						} else {
							ca.town = segmentsGetStringForPattern(segments, ms_Pattern_road);
						}
					}
				}
			}
            // ca.street = segmentsGetStringForPattern(segments, ms_Pattern_street);
			ArrayList<String> stree = new ArrayList<String>();
			stree.add(segmentsGetStringForPattern(segments, ms_Pattern_street));
			ArrayList<String> roads = segmentsGetStringListForPattern(segments, ms_Pattern_road);
			boolean flag2 = segmentsGetStringForPattern(segments, ms_Pattern_street) != null && segmentsGetStringForPattern(segments, ms_Pattern_street).length() > 0 ;
			roads = flag2 ? stree :segmentsGetStringListForPattern(segments, ms_Pattern_road);
      
			ArrayList<String> near = segmentsGetStringListForPattern(segments, ms_Pattern_roadnear);
			for (Iterator<String> it = near.iterator(); it.hasNext();) {
			    roads.add(it.next());
			}
			ca.roads = roads;
			ca.underground = segmentsGetStringForPattern(segments, ms_Pattern_underground);
			ca.number = segmentsGetStringForPattern(segments, ms_Pattern_number);
			ca.plaza = segmentsGetStringForPattern(segments, ms_Pattern_plaza);
			ca.ip = segmentsGetStringForPattern(segments, ms_Pattern_ip);
			//ca.town = segmentsGetStringForPattern(segments, ms_Pattern_town);
			ca.village = segmentsGetStringForPattern(segments, ms_Pattern_village);
		} catch (Exception e) {
			Logger.error("*****病案首页插入中间表报错*****患者信息地址解析报错("+source+")：",e);
			// e.printStackTrace();
		}
        return ca;          
    }
}
