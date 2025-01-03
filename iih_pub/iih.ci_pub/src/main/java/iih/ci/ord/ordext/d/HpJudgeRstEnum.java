package iih.ci.ord.ordext.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface HpJudgeRstEnum {

    @DmEnumDesc(name="自费",description="适应症判断结果为自费")
    public static final String SELFPAY="0"; //自费
    @DmEnumDesc(name="待判断",description="未进行医保适应症判断")
    public static final String WAITING_JUDGE="1"; //待判断
    @DmEnumDesc(name="医保",description="适应症判断结果为医保")
    public static final String HP="2"; //医保
    @DmEnumDesc(name="不判断",description="费用项目不需要计费")
    public static final String NOT_JUDGE="5"; //不判断
    @DmEnumDesc(name="未启用医保判断",description="未启用医保判断")
    public static final String DISABLED="6"; //未启用医保判断
}	
