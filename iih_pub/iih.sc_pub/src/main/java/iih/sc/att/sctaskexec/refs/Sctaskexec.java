package iih.sc.att.sctaskexec.refs;

import iih.sc.att.sctaskexec.d.SctaskexecDO;
import xap.sys.appfw.refinfo.RefGridModel;

/**考勤执行参照模型
 * @author ccj
 *
 */
public class Sctaskexec extends RefGridModel{
	@Override
	public String[] getShowFieldCode() {
		return new String[]{SctaskexecDO.NAME,SctaskexecDO.CODE};
	}
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{SctaskexecDO.ID_TASKPL};
	}
	@Override
	public String[] getShowFieldName() {
		return new String[]{"考勤执行名称","编码"};
	}
	@Override
	public String getPkFieldCode() {
		return SctaskexecDO.ID_TASKPL;
	}
	@Override
	public String getRefCodeField() {
		return SctaskexecDO.CODE;
	}
	@Override
	public String getRefNameField() {
		return SctaskexecDO.NAME;
	}
	@Override
	public String getTableName() {
		return new SctaskexecDO().getTableName();
	}
}
