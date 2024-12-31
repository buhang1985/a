package iih.pe.pitm.pesrvitem.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeItemStatusEnum {

    @DmEnumDesc(name="未完",description="")
	public static final Integer PESTUNFINISHED=0; //未完
    @DmEnumDesc(name="完成",description="")
	public static final Integer PESTFINISHED=1; //完成
    @DmEnumDesc(name="补检",description="")
	public static final Integer PESTRECHECK=2; //补检
    @DmEnumDesc(name="自请免做",description="拒绝检查")
	public static final Integer PESTGIVEUP=3; //自请免做
    @DmEnumDesc(name="未做",description="")
	public static final Integer PESTUNDO=4; //未做
    @DmEnumDesc(name="无法测试",description="")
	public static final Integer PESTUNABLE=5; //无法测试
    @DmEnumDesc(name="报告后补",description="")
	public static final Integer PESTPOSTREPORT=6; //报告后补
    @DmEnumDesc(name="免做",description="")
	public static final Integer PESTEX=7; //免做
    @DmEnumDesc(name="延迟检查",description="")
	public static final Integer PESTPOSTCHECK=8; //延迟检查
}	
