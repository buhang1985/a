package iih.bd.srv.preformat.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.srv.emreditor.d.EmrEditorDO;
import iih.bd.srv.mrtplseg.d.MrTplSegmentDO;
import iih.bd.srv.preformat.d.MrPreFormatDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 填充病历编辑器信息
 * 
 * @author hao_wu 2019-7-10
 *
 */
public class FillMrEdInfoBp {

	@SuppressWarnings("unchecked")
	public void exec(MrPreFormatDO[] mrPreFormats) throws BizException {
		if (ArrayUtils.isEmpty(mrPreFormats)) {
			return;
		}

		// 构建医疗记录片段模板主键集合
		ArrayList<String> mrTplSecIdList = new ArrayList<>();
		for (MrPreFormatDO mrPreFormatDO : mrPreFormats) {
			String mrTplSecId = mrPreFormatDO.getId_mrtplsec();
			if (StringUtils.isNotBlank(mrTplSecId)) {
				mrTplSecIdList.add(mrTplSecId);
			}
		}
		if (mrTplSecIdList.size() <= 0) {
			return;
		}

		// 查询医疗记录片段模板
		DAFacade daFacade = new DAFacade();
		List<MrTplSegmentDO> mrTplSecs = (List<MrTplSegmentDO>) daFacade.findByPKs(MrTplSegmentDO.class,
				mrTplSecIdList.toArray(new String[0]));
		if (mrTplSecs == null || mrTplSecs.size() <= 0) {
			return;
		}

		// 构建医疗记录编辑器主键集合
		// 构建医疗记录主键Map
		ArrayList<String> mrEdIds = new ArrayList<>();
		// <医疗记录片段模板主键,医疗记录主键>
		HashMap<String, String> mrEdIdMap = new HashMap<>();
		for (MrTplSegmentDO mrTplSegmentDO : mrTplSecs) {
			String mrEdId = mrTplSegmentDO.getId_mred();
			if (StringUtils.isNotBlank(mrEdId)) {
				mrEdIds.add(mrEdId);
				mrEdIdMap.put(mrTplSegmentDO.getId_mrtplsec(), mrEdId);
			}
		}
		if (mrEdIds.size() <= 0) {
			return;
		}

		// 查询医疗记录编辑器
		List<EmrEditorDO> mrEdList = (List<EmrEditorDO>) daFacade.findByPKs(EmrEditorDO.class,
				mrEdIds.toArray(new String[0]));
		if (mrEdList == null || mrEdList.size() <= 0) {
			return;
		}

		// 构建医疗记录编辑器名称Map
		HashMap<String, String> mrEdNameMap = new HashMap<>();
		for (EmrEditorDO emrEditorDO : mrEdList) {
			mrEdNameMap.put(emrEditorDO.getId_mred(), emrEditorDO.getName());
		}

		// 回写病历编辑器名称
		for (MrPreFormatDO mrPreFormatDO : mrPreFormats) {
			String mrTplSecId = mrPreFormatDO.getId_mrtplsec();
			if (StringUtils.isBlank(mrTplSecId)) {
				continue;
			}
			if (!mrEdIdMap.containsKey(mrTplSecId)) {
				continue;
			}
			String mrEdId = mrEdIdMap.get(mrTplSecId);
			if (!mrEdNameMap.containsKey(mrEdId)) {
				continue;
			}
			mrPreFormatDO.setName_mred(mrEdNameMap.get(mrEdId));
		}
	}
}
