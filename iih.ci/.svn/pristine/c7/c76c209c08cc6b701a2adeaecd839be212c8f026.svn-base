package iih.ci.ord.s.bp.cfg.rulecfg.rule.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.srv.notice.d.MedNoticeDO;
import iih.bd.srv.notice.i.IMednoticeRService;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 设置检验合单中的注意事项
 * 
 * @author HUMS
 *
 */
public class SplitLisSetNoticesBP {

	/**
	 * 设置集合中CiLisOrSmsIoDTO的Announcements属性值
	 * @param ciLisOrSmsIoList
	 * @throws BizException
	 */
	public List<CiLisOrSmsIoDTO> exec(List<CiLisOrSmsIoDTO> ciLisOrSmsIoList) throws BizException {

		StringBuffer noticeBuffer = new StringBuffer();
		List<String> noticeIdList = new ArrayList<String>();

		for (CiLisOrSmsIoDTO ciLisOrSmsIo : ciLisOrSmsIoList) {
			if (StringUtils.isNotEmpty(ciLisOrSmsIo.getAnnouncements())) {
				String[] noticeIdArr = ciLisOrSmsIo.getAnnouncements().split(",");
				noticeIdList.addAll(Arrays.asList(noticeIdArr));
			}
		}

		// 获取注意事项信息，赋值到检验申请单Announcements属性中
		Map<String, MedNoticeDO> noticeMap = this.getNoticeMap(noticeIdList);
		if (noticeMap.size() > 0) {
			for (CiLisOrSmsIoDTO ciLisOrSmsIo : ciLisOrSmsIoList) {
				String[] noticeIdArr = ciLisOrSmsIo.getAnnouncements().split(",");
				for (String noticeId : noticeIdArr) {
					if (noticeBuffer.length() > 0) {
						noticeBuffer.append(System.lineSeparator());
					}
					noticeBuffer.append(noticeMap.get(noticeId).getName());
				}

				ciLisOrSmsIo.setAnnouncements(noticeBuffer.toString());
				noticeBuffer.setLength(0);
			}
		}
		
		return ciLisOrSmsIoList;
	}

	/**
	 * 根据检验申请单中配置的注意事项，获取对应的注意事项信息
	 * 
	 * @param noticeIdList
	 * @return
	 * @throws BizException
	 */
	private Map<String, MedNoticeDO> getNoticeMap(List<String> noticeIdList) throws BizException {

		Map<String, MedNoticeDO> noticeMap = new HashMap<String, MedNoticeDO>();
		if (noticeIdList.size() > 0) {

			IMednoticeRService noticeRService = (IMednoticeRService) ServiceFinder.find(IMednoticeRService.class);
			MedNoticeDO[] medNotices = noticeRService.findByIds(noticeIdList.toArray(new String[noticeIdList.size()]),
					FBoolean.FALSE);

			for (MedNoticeDO medNotice : medNotices) {
				noticeMap.put(medNotice.getId_notice(), medNotice);
			}
		}

		return noticeMap;
	}

}
