package skillpoints.apiimpl;

import skillpoints.api.API;
import skillpoints.api.APIBase;
import skillpoints.api.APIStatus;
import skillpoints.apiimpl.v1.APIimplv1;

public class APISelector implements APIBase {
	private APIimplv1 apIimplv1 = null;

	private APISelector() {}

	public static void init() {
		API.setAPI(new APISelector());
	}

	@Override
	public APIBase getAPI(int maxVersion) {
		if (maxVersion <= 0) {
			return this;
		} else {
			if (apIimplv1 == null) {
				apIimplv1 = new APIimplv1(1, APIStatus.OK);
			}
			return apIimplv1;
		}
	}

	@Override
	public APIStatus getStatus() {
		return APIStatus.ERROR;
	}

	@Override
	public int getVersion() {
		return 0;
	}
}
