package iih.bd.fc.quesite.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据部门ID获取门诊诊间集合
 * 
 * @author liubin
 *
 */
public class GetRoomsBP {
	/**
	 * 根据部门ID获取门诊诊间集合
	 * 
	 * @param depId 部门ID
	 * @return
	 * @throws BizException
	 */
	public String[] getRooms(String depId) throws BizException {
		if(StringUtil.isEmptyWithTrim(depId))
			return null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT DISTINCT BS.ROOM FROM BD_QUE_SITE BS ");
		sb.append("WHERE BS.SD_QUESITETP = ? ");
		sb.append("AND BS.FG_ACTIVE = ? ");
		sb.append("AND NVL(BS.ROOM, '~') <> '~' ");
		sb.append("AND BS.IDS_DEP_ENABLE LIKE ?  ");
		String sql  = sb.toString();
		SqlParam param = new SqlParam();
		param.addParam(IBdFcDictCodeConst.SD_QUESITETP_OP);
		param.addParam(FBoolean.TRUE);
		param.addParam("%"+depId+"%");
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if(!ListUtil.isEmpty(list)){
			return list.toArray(new String[0]);
		}
		return null;
	}
}
