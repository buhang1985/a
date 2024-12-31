package iih.bd.srv.pub;

public interface IBdSrvEventConst {
	public static final String UDIDOC_ADDDELMOD_EVENT_SOURCEID="xap.sys.xbd.udi.d.UdidocDO";  //自定义档案增删改事件源
	public static final String SRVCATE_ADDDELMOD_EVENT_SOURCEID="iih.bd.srv.srvcate.d.SrvCateDO"; //服务基本分类增删改事件源
	public static final String MEDSRV_ADDDELMOD_EVENT_SOURCEID="iih.bd.srv.medsrv.d.MedsrvAggDO"; //医疗服务增删改事件源
	public static final String DIAGDEF_ADDDELMOD_EVENT_SOURCEID="iih.bd.srv.diagdef.d.DiagdefAggDO"; //医疗服务诊断增删改事件源
	public static final String FREQDEF_ADDDELMOD_EVENT_SOURCEID="iih.bd.srv.freqdef.d.FreqdefAggDO"; //医疗服务频次增删改事件源
	public static final String MEDUSAGE_ADDDELMOD_EVENT_SOURCEID="iih.bd.srv.medusage.d.MedUsageDO"; //医疗服务用法增删改事件源
	public static final String ORTEMPL_ADDDELMOD_EVENT_SOURCEID="iih.bd.srv.ortpl.d.OrtmplAggDO"; //医疗服务用法增删改事件源
	public static final String ORDEPTWF_ADDDELMOD_EVENT_SOURCEID="iih.bd.fc.wf.d.WfAggDO"; //医疗流向配置增删改事件源
	public static final String MEDSRV_FEECOMPARE_EVENT_SOURCEID="iih.bd.srv.medsrv.d.MedSrvDO"; //付款策略费用对照修改事件

}
