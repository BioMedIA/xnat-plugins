package org.nrg.xnat.turbine.modules.actions;

import org.apache.turbine.util.RunData;
import org.apache.velocity.context.Context;
import org.nrg.xdat.XDAT;
import org.nrg.xdat.turbine.modules.actions.SecureAction;
import org.nrg.xdat.turbine.utils.TurbineUtils;
import org.nrg.xft.security.UserI;
import org.nrg.xnat.biomedia.userAttributes.entities.UserAttributes;
import org.nrg.xnat.biomedia.userAttributes.services.UserAttributesService;

/**
 * Created by gmlenz on 08/12/16.
 */
public class CheckTerms extends SecureAction {
    @Override
    public void doPerform(RunData data, Context context) throws Exception {
        String projectId = (String) TurbineUtils.GetPassedParameter("project", data);

        UserI user = TurbineUtils.getUser(data);

        UserAttributesService service = XDAT.getContextService().getBean(UserAttributesService.class);
        String username = user.getUsername();
        try {
            UserAttributes extendedUser = service.findByUsername(username);

            if (extendedUser.hasAcceptedTerms()) {
                data.setMessage("Already signed the User Terms!");
                data.setScreenTemplate("Index.vm");
            } else {
                data.setScreenTemplate("sign_userterms.vm");
            }

        } catch (Exception e) {
            e.printStackTrace();
            data.setMessage("Could not check whether user has already signed the terms...");
            data.setScreenTemplate("Index.vm");
        }

    }
}
