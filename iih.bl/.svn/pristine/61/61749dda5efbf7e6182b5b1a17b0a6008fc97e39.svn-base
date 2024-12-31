package iih.bl.st.blstoep.s.rule;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.bizrule.IRule;

/**
 * 结算数据插入前规则
 * @author ly 2020/01/14
 *
 */
public class BlStOepInsertBefRule implements IRule<BlStOepDO> {

	@Override
	public void process(BlStOepDO... dos) throws BizException {
		
		for (BlStOepDO blStOepDO : dos) {
			
			if(StringUtil.isEmpty(blStOepDO.getId_enttp())){
				blStOepDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
			}
			
			if(StringUtil.isEmpty(blStOepDO.getCode_enttp())){
				blStOepDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
			}
		}
	}
}
