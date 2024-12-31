package iih.nm.net.examquatt.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface AttTpEunm {

    @DmEnumDesc(name="图片",description="")
	public static final Integer PICTURE=0; //图片
    @DmEnumDesc(name="文档",description="")
	public static final Integer DOCUMENT=1; //文档
}	
