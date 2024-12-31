package iih.pis.phk.dto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface GuidModType {

    @DmEnumDesc(name="图片",description="图片")
	public static final Integer IMG=1; //图片
    @DmEnumDesc(name="文本",description="文本")
	public static final Integer TEXT=2; //文本
    @DmEnumDesc(name="网页",description="网页")
	public static final Integer URL=3; //网页
    @DmEnumDesc(name="部门",description="部门")
	public static final Integer DEPT=4; //部门
    @DmEnumDesc(name="平面图",description="平面图")
	public static final Integer ICHNOGRAPHY=5; //平面图
    @DmEnumDesc(name="价格查询",description="价格查询")
	public static final Integer PRICQRY=6; //价格查询
}	
