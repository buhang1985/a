package iih.hp.cp.hpcp.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface ExtCliCacheTp {
    @DmEnumDesc(name="元素类型缓存",description="")
	public static final Integer EleTP=1;
    
    @DmEnumDesc(name="元素标准模板缓存",description="")
	public static final Integer EleStd=2;
}	
