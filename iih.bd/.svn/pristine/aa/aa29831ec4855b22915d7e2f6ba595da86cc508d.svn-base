package iih.bd.fc.quesite.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.d.desc.QueSiteDODesc;
import iih.bd.fc.quesite.i.IQuesiteRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据诊间获取诊椅（即站点）集合
 * 
 * @author liubin
 *
 */
public class GetQueSiteByRoomBP {

	private static final String ALL = "%";

	/**
	 * 根据诊间获取诊椅（即站点）集合
	 * 
	 * @param room 诊间
	 * @return
	 * @throws BizException
	 */
	public QueSiteDO[] getQueSiteByRoom(String depId, String room) throws BizException {
		if (StringUtil.isEmptyWithTrim(depId) || StringUtil.isEmptyWithTrim(room)) {
			return null;
		}
		String whereStr = String
				.format("%s.SD_QUESITETP = '%s' AND %s.FG_ACTIVE = '%s' AND %s.IDS_DEP_ENABLE LIKE '%s' AND NVL(%s.ROOM, '~') <> '~' ",
						QueSiteDODesc.TABLE_ALIAS_NAME, IBdFcDictCodeConst.SD_QUESITETP_OP,
						QueSiteDODesc.TABLE_ALIAS_NAME, FBoolean.TRUE, QueSiteDODesc.TABLE_ALIAS_NAME, "%" + depId
								+ "%", QueSiteDODesc.TABLE_ALIAS_NAME);
		if (!ALL.equals(room.trim())) {
			whereStr = String.format("%s AND %s.ROOM = '%s'", whereStr, QueSiteDODesc.TABLE_ALIAS_NAME, room);
		}
		// modified by zhengcm 2018-01-03 按诊间+诊椅名称排序
		String orderStr = String.format("%s.ROOM, %s.NAME", QueSiteDODesc.TABLE_ALIAS_NAME,
				QueSiteDODesc.TABLE_ALIAS_NAME);
		IQuesiteRService siteRServ = ServiceFinder.find(IQuesiteRService.class);
		return siteRServ.find(whereStr, orderStr, FBoolean.FALSE);
	}
}
