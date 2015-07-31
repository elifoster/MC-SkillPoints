package skillpoints.api.v0;

import skillpoints.api.APIBase;
import skillpoints.api.APIStatus;

/**
 * Filler object to represent the API until SkillPoints has the chance to
 * initialize itself.
 *
 */
public class NoAPI implements APIBase {

	@Override
	public APIStatus getStatus() {
		return APIStatus.API_NOT_INITIALIZED;
	}

	@Override
	public int getVersion() {
		return 0;
	}

	@Override
	public APIBase getAPI(int maxVersion) {
		return this;
	}
}