package iih.nm.nhr.nmnhrschedlv.i;

import java.text.ParseException;

import iih.nm.nhr.nmnhrschedlv.d.NmNhrSchedLvDO;
import xap.mw.core.data.BizException;

public interface INmnhrschedlvUschedweekService {
	public abstract void updateSchedWeek(NmNhrSchedLvDO[] dos) throws BizException, ParseException;
}
