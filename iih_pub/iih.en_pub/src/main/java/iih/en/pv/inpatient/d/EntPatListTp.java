package iih.en.pv.inpatient.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EntPatListTp {

    @DmEnumDesc(name="我的患者",description="我的患者")
    public static final String PERSONALPAT="0"; //我的患者
    @DmEnumDesc(name="医疗组患者",description="医疗组患者")
    public static final String WORKGROUPPAT="1"; //医疗组患者
    @DmEnumDesc(name="科室患者",description="科室患者")
    public static final String DEPPAT="3"; //科室患者
    @DmEnumDesc(name="跨科处置患者",description="跨科处置患者")
    public static final String CROSSDEPTPAT="5"; //跨科处置患者
    @DmEnumDesc(name="其他",description="其他")
    public static final String OTHERPAT="9"; //其他
    @DmEnumDesc(name="会诊患者",description="会诊患者")
    public static final String CONSULTATIONPAT="2"; //会诊患者
    @DmEnumDesc(name="出院患者",description="出院患者")
    public static final String LVHOSPAT="4"; //出院患者
    @DmEnumDesc(name="转科患者",description="转科患者")
    public static final String TRANSDEPPAT="6"; //转科患者
    @DmEnumDesc(name="授权患者",description="授权患者")
    public static final String ENAUTHPAT="7"; //授权患者
}	
