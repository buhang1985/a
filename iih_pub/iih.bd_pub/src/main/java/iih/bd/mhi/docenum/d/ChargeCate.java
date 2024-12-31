package iih.bd.mhi.docenum.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface ChargeCate {

    @DmEnumDesc(name="西药",description="西药")
    public static final String WESTERNMEDICINE="11"; //西药
    @DmEnumDesc(name="中成药",description="中成药")
    public static final String CHINESEMEDICINE="12"; //中成药
    @DmEnumDesc(name="中草药",description="中草药")
    public static final String CHINESEHERBALMEDICINE="13"; //中草药
    @DmEnumDesc(name="检查费",description="检查费")
    public static final String INSPECTIONFEES="21"; //检查费
    @DmEnumDesc(name="特殊检查费",description="特殊检查费")
    public static final String SPECIALINSPECTIONFEES="22"; //特殊检查费
    @DmEnumDesc(name="输氧费",description="输氧费")
    public static final String OXYGENFEES="23"; //输氧费
    @DmEnumDesc(name="手术费",description="手术费")
    public static final String SURGERYFEES="24"; //手术费
    @DmEnumDesc(name="化验费",description="化验费")
    public static final String LABFEES="25"; //化验费
    @DmEnumDesc(name="输血费",description="输血费")
    public static final String BLOODTRANSFUSIONFEES="26"; //输血费
    @DmEnumDesc(name="诊察费",description="诊察费")
    public static final String EXAMINATIONFEES="27"; //诊察费
    @DmEnumDesc(name="治疗费",description="治疗费")
    public static final String TREATMENTFEES="31"; //治疗费
    @DmEnumDesc(name="特殊治疗费",description="特殊治疗费")
    public static final String SPECIALTREATMENTFEES="32"; //特殊治疗费
    @DmEnumDesc(name="护理费",description="护理费")
    public static final String NURSINGFEES="33"; //护理费
    @DmEnumDesc(name="床位费",description="床位费")
    public static final String BEDFEES="34"; //床位费
    @DmEnumDesc(name="手术费",description="手术费")
    public static final String SURGERYFEES2="41"; //手术费
    @DmEnumDesc(name="住院费",description="住院费")
    public static final String HOSPITALFEES="42"; //住院费
    @DmEnumDesc(name="麻醉费",description="麻醉费")
    public static final String ANESTHESIAFEES="43"; //麻醉费
    @DmEnumDesc(name="接生费",description="接生费")
    public static final String ADMISSIONFEES="44"; //接生费
    @DmEnumDesc(name="检验费",description="检验费")
    public static final String EXAMINEFEES="45"; //检验费
    @DmEnumDesc(name="注射费",description="注射费")
    public static final String INJECTIONFEES="46"; //注射费
    @DmEnumDesc(name="其他费用",description="其他费用")
    public static final String OTHERFEES="91"; //其他费用
    @DmEnumDesc(name="挂号费",description="挂号费")
    public static final String REGISTRATIONFEES="92"; //挂号费
    @DmEnumDesc(name="特殊材料费",description="特殊材料费")
    public static final String SPECIALMATERIALFEES="93"; //特殊材料费
    @DmEnumDesc(name="材料费",description="材料费")
    public static final String MATERIALFEES="94"; //材料费
    @DmEnumDesc(name="进口材料费",description="进口材料费")
    public static final String IMPORTMATERIALSFEES="95"; //进口材料费
    @DmEnumDesc(name="诊疗费",description="诊疗费")
    public static final String MEDICALFEES="96"; //诊疗费
    @DmEnumDesc(name="伙食费",description="伙食费")
    public static final String FOODFEES="97"; //伙食费
    @DmEnumDesc(name="骁悉",description="骁悉")
    public static final String SMART="98"; //骁悉
    @DmEnumDesc(name="百令胶囊",description="百令胶囊")
    public static final String BAILINGCAPSULE="99"; //百令胶囊
}	
