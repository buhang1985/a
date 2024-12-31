package iih.ci.ord.s.bp;

import iih.ci.ord.ciordems.d.EmsOrSrvSc;
import iih.ci.ord.ems.d.CiEnContextDTO;

public abstract class GetAbsMedSrvScBindMMBP {
	public abstract EmsOrSrvSc[] exec(String openType,String sd_inputmethod, String blurValue,CiEnContextDTO conetxtDTO) ;
}
