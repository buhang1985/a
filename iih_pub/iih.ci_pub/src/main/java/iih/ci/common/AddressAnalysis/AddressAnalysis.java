package iih.ci.common.AddressAnalysis;

import iih.ci.mrfp.mrfpxml.d.Address;

public class AddressAnalysis {
	/**
	 * 根据描述获得详细地址划分
	 * @param des
	 * @return
	 */
	public Address getDetailAdderss(String des)
	{
		/*
		 *中国现行的行政区划实行如下原则：
		 *一级省级行政区：分为省、自治区、直辖市、特别行政区；
		 *二级地级行政区：分为地级市、地区、自治州、盟；
		 *三级县级行政区：分为市辖区、县、自治县、县级市、旗、自治旗、林区、特区；
		 *四级乡级行政区：分为镇、乡、民族乡、街道、苏木、民族苏木、区公所；
		 *五级村级行政区：分为行政村、社区、居、嘎査；
		 *六级组级行政区：分为自然村村民小组、社区居民小组。
		 */
		
		Address addr = new Address();
		if(des==null)
			return addr;
		String[] arrFirst = {"省","自治区","市","特别行政区"};
		String[] arrSecond = {"市","区","自治州","盟"};
		String[] arrThird = {"区","县","市","旗"};//结尾重复的过滤了
		String[] arrForth = {"镇","乡","街道","苏木","区公所"};
		String[] arrFifth = {"村","社区","居","嘎査"};
		String[] arrsixth = {"小组"};
		String region = "";
		region = SpiltRegion(arrFirst,des);
		addr.setState(region);
		des = des.replace(region, "");
		region = SpiltRegion(arrSecond,des);
		addr.setCity(region);
		des = des.replace(region, "");
		region = SpiltRegion(arrThird,des);
		addr.setCounty(region);
		des = des.replace(region, "");
		region = SpiltRegion(arrForth,des);
		addr.setTownship(region);
		des = des.replace(region, "");
		region = SpiltRegion(arrFifth,des);
		addr.setStreetName(region);
		des = des.replace(region, "");
		addr.setHoseNumber(des);
		return addr;
	}
	
	/**
	 * 获取特定行政区
	 * @param standard
	 * @param des
	 * @return
	 */
	private String SpiltRegion(String[] standards, String des)
	{
		String region = "";
		if(standards!=null&&standards.length>0)
		{
			int idx = -1;
			for(int i =0;i<standards.length;i++)
			{
				idx = des.indexOf(standards[i]);
				if(idx!=-1)
				{
					region = des.substring(0,idx)+standards[i];
					break;
				}
			}
		}
		return region; 
	}
}
