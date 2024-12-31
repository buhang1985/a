package iih.pe.pitm.perstsuggtp.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeRstSuggQueryEnum {

    @DmEnumDesc(name="复查",description="复查")
	public static final Integer PESUGGRECHECK=01; //复查
    @DmEnumDesc(name="进一步检查",description="进一步检查")
	public static final Integer PESUGGFORWARD=02; //进一步检查
    @DmEnumDesc(name="一般处理",description="一般处理")
	public static final Integer PESUGGDEAL=03; //一般处理
    @DmEnumDesc(name="就医",description="就医")
	public static final Integer PESUGGMEDICAL=04; //就医
}	
