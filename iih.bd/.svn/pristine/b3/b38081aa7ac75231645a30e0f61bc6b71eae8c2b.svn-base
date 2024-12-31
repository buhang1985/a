package iih.bd.srv.s.bp;

import java.util.Hashtable;

import iih.bd.srv.oth.d.MedSrvWordFreqDO;
import iih.bd.srv.pub.BdSrvAppUtils;
import iih.bd.srv.pub.BdSrvUtils;
import iih.bd.utils.log.BdSrvLogUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

/**
 * 词频数据信息保存操作BP
 */
public class WordFreqInfoSaveBP {
	/**
	 * 词频数据信息保存操
	 * 
	 * @param wfpkdata 词频主键及其数据
	 * @param bizcntht 词频统计集合全集
	 * @param wfdos    更新词频记录集合
	 * @throws BizException
	 */
	@SuppressWarnings("rawtypes")
	public void exec(MedSrvWordFreqDO wfpkdata, Hashtable bizcntht, MedSrvWordFreqDO[] wfdos) throws BizException {
		try {
			// 有效性判断
			if (bizcntht == null || bizcntht.size() <= 0)
				return;
			int iL = 0;

			// 更新词频记录存在性判断
			if (!BdSrvUtils.isEmpty(wfdos)) {
				iL = wfdos.length;
			}

			// 遍历
			String bizid = null;
			for (int i = 0; i < iL; i++) {
				bizid = wfdos[i].getId_biz();
				wfdos[i].setCnt(wfdos[i].getCnt() + (Integer) bizcntht.get(bizid));
				wfdos[i].setStatus(DOStatus.UPDATED);
				bizcntht.remove(bizid);
			}

			// 获得新建词频项集合
			MedSrvWordFreqDO[] insertwfdos = getInsertWFdos(wfpkdata, bizcntht);

			// 数据集合合并
			MedSrvWordFreqDO[] savedos = doMerge(insertwfdos, wfdos);

			// 词频数据保存
			wfInfoSave(savedos);

		} catch (Throwable e) {
			BdSrvLogUtils.logExAndTitle(e, "词频错误");
		}
	}

	/**
	 * 数据集合并处理
	 * 
	 * @param insertdos
	 * @param updatedos
	 * @return
	 */
	private MedSrvWordFreqDO[] doMerge(MedSrvWordFreqDO[] insertdos, MedSrvWordFreqDO[] updatedos) {
		if (BdSrvUtils.isEmpty(insertdos))
			return updatedos;
		if (BdSrvUtils.isEmpty(updatedos))
			return insertdos;

		int ii = insertdos.length;
		int iL = ii + updatedos.length;
		MedSrvWordFreqDO[] rtndos = new MedSrvWordFreqDO[iL];

		for (int i = 0; i < iL; i++) {
			if (i < ii) {
				rtndos[i] = insertdos[i];
			} else {
				rtndos[i] = updatedos[i - ii];
			}
		}

		return rtndos;
	}

	/**
	 * 获得新建词频项数组
	 * 
	 * @param wfpkdata
	 * @param bizcntht
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private MedSrvWordFreqDO[] getInsertWFdos(MedSrvWordFreqDO wfpkdata, Hashtable bizcntht) {
		if (bizcntht == null || bizcntht.size() <= 0)
			return null;
		MedSrvWordFreqDO[] rtndos = new MedSrvWordFreqDO[bizcntht.size()];
		int i = 0;

		// 遍历
		for (Object key : bizcntht.keySet()) {
			rtndos[i] = new MedSrvWordFreqDO();
			// rtndos[i].setId_wordfreq(null);
			rtndos[i].setId_grp(wfpkdata.getId_grp());
			rtndos[i].setId_org(wfpkdata.getId_org());
			rtndos[i].setId_dept(wfpkdata.getId_dept());
			rtndos[i].setId_emp(wfpkdata.getId_emp());
			rtndos[i].setBiz_classtype(wfpkdata.getBiz_classtype());
			rtndos[i].setId_biz(key.toString());
			rtndos[i].setCnt((Integer) bizcntht.get(key));
			rtndos[i].setStatus(DOStatus.NEW);
			i += 1;
		}

		// 返回
		return rtndos;
	}

	/**
	 * 词频数据保存
	 * 
	 * @param savedos
	 * @throws BizException
	 */
	private void wfInfoSave(MedSrvWordFreqDO[] savedos) throws BizException {
		BdSrvAppUtils.getSrvwordfreqService().save(savedos);
	}

}
