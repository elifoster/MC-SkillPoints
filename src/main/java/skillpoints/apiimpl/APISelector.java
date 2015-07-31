package skillpoints.apiimpl;

import skillpoints.api.API;
import skillpoints.api.APIBase;
import skillpoints.api.APIStatus;
import skillpoints.apiimpl.v1.APIHandlerV1;

public class APISelector implements APIBase {
	private APIHandlerV1 apiHandlerV1 = null;

	private APISelector() {}

	public static void init() {
		API.setAPI(new APISelector());
	}

	@Override
	public APIBase getAPI(int maxVersion) {
		if (maxVersion <= 0) {
			return this;
		} else {
			if (apiHandlerV1 == null) {
				apiHandlerV1 = new APIHandlerV1(1, APIStatus.OK);
			}
			return apiHandlerV1;
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
