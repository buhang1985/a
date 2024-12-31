package iih.ci.ord.dto.skintest.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface SkinTestJudgeRstEnum {

    @DmEnumDesc(name="皮试结果为阳性，询问是否继续用药，并录入强制用药原因",description="皮试结果为阳性，询问是否继续用药，并录入强制用药原因")
    public static final String SKINTESTASKTOUSE="01"; //皮试结果为阳性，询问是否继续用药，并录入强制用药原因
    @DmEnumDesc(name="不能用药，提示阳性记录不允许用药",description="不能用药，提示阳性记录不允许用药")
    public static final String SKINTESTNOUSE="02"; //不能用药，提示阳性记录不允许用药
    @DmEnumDesc(name="弹出皮试记录界面，医生自己选择",description="弹出皮试记录界面，医生自己选择")
    public static final String SKINTESTSHOWSKINFORM="03"; //弹出皮试记录界面，医生自己选择
    @DmEnumDesc(name="生成皮试医嘱，终止签署",description="生成皮试医嘱")
    public static final String SKINTESTCREATESKINORDER="04"; //生成皮试医嘱，终止签署
    @DmEnumDesc(name="允许开立，提示皮试结果未归，录入强制用药原因",description="允许开立，提示皮试结果未归，录入强制用药原因")
    public static final String SKINTESTNORSTASKTOUSE="05"; //允许开立，提示皮试结果未归，录入强制用药原因
    @DmEnumDesc(name="存在过敏史，弹出过敏信息，询问是否用药",description="存在过敏史，弹出过敏信息，询问是否用药")
    public static final String SKINTESTALHISSHOW="06"; //存在过敏史，弹出过敏信息，询问是否用药
    @DmEnumDesc(name="皮试结果未归，是否签署医嘱",description="在执行环节进行控制，则弹出提示【皮试结果未归，是否签署医嘱】")
    public static final String SKINTESTNORSTTOSIGN="07"; //皮试结果未归，是否签署医嘱
}	
