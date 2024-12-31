package iih.pe.pitm.pesrvbcatlog.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeSrvbCatlogEnum {

    @DmEnumDesc(name="常规",description="常规")
	public static final Integer PECATLOGGENERAL=1; //常规
    @DmEnumDesc(name="影像学",description="影像学")
	public static final Integer PECATLOGRADIO=2; //影像学
    @DmEnumDesc(name="检验",description="检验")
	public static final Integer PECATLOGLAB=3; //检验
}	
