package iih.bl.st.dto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnReFundTpEnum {

    @DmEnumDesc(name="取号",description="取号")
    public static final String ENREFUND_FETCH="01"; //取号
    @DmEnumDesc(name="换号",description="换号")
    public static final String ENREFUND_CHANGE="02"; //换号
    @DmEnumDesc(name="退号",description="退号")
    public static final String ENREFUND_CANCEL="03"; //退号
}	
