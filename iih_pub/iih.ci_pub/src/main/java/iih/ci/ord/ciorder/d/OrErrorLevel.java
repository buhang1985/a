package iih.ci.ord.ciorder.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface OrErrorLevel {

    @DmEnumDesc(name="正确数据",description="数据正常可以正常保存不影响后续业务")
    public static final String CORRECT="A"; //正确数据
    @DmEnumDesc(name="警告数据",description="数据存在问题，但不影响后续业务，可以继续执行")
    public static final String NOTICE="B"; //警告数据
    @DmEnumDesc(name="错误数据",description="数据存在错误，影响后续业务不允许签署")
    public static final String ERROR="C"; //错误数据
}	
