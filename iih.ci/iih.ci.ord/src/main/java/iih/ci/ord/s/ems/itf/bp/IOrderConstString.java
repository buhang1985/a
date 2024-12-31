package iih.ci.ord.s.ems.itf.bp;

public interface IOrderConstString {
	public static String STR_ERROR_ORSTATUS = "医嘱状态已经发生变化，请刷新列表！";
	public static String STR_ERROR_OREXEC_REVERT = "所选的医嘱已经执行或收费，不能撤销！";
	public static String STR_ERROR_OREXEC_CANCEL = "所选的医嘱已经执行或收费，不能作废！";
	public static String STR_ERROR_BUBT_CANCEL = "备血医嘱已关联用血，请确认！";
}
