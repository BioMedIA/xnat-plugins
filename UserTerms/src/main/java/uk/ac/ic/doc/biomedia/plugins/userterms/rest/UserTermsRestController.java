/*
package uk.ac.ic.doc.biomedia.plugins.userterms.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.nrg.framework.annotations.XapiRestController;
import org.nrg.xdat.security.services.RoleHolder;
import org.nrg.xdat.security.services.UserManagementServiceI;
import uk.ac.ic.doc.biomedia.plugins.userterms.entities.UserTerms;
import uk.ac.ic.doc.biomedia.plugins.userterms.services.UserTermsService;
import org.nrg.xdat.rest.AbstractXapiRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Api(description = "XNAT User Additional Attributes API")
@XapiRestController
@RequestMapping(value = "/attributes")
public class UserTermsRestController extends AbstractXapiRestController {
    protected UserTermsRestController(UserManagementServiceI userManagementService, RoleHolder roleHolder) {
        super(userManagementService, roleHolder);
    }

    @ApiOperation(value = "Returns a list of all subject mappings.",
                  notes = "Disregards source system.",
                  response = UserTerms.class, responseContainer = "List")
    @ApiResponses({@ApiResponse(code = 200, message = "Subject mappings successfully retrieved."),
                   @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
                   @ApiResponse(code = 500, message = "Unexpected error")})
    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public ResponseEntity<List<UserTerms>> getEntities() {
        return new ResponseEntity<>(_service.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Creates a new subject mapping.",
                  notes = "Disregards source system.",
                  response = UserTerms.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Subject mapping successfully created."),
                   @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
                   @ApiResponse(code = 500, message = "Unexpected error")})
    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST)
    public ResponseEntity<UserTerms> createEntity(@RequestBody final UserTerms entity) {
        final UserTerms created = _service.create(entity);
        return new ResponseEntity<>(created, HttpStatus.OK);
    }

    @ApiOperation(value = "Retrieves the indicated subject mapping.",
                  notes = "Based on primary key ID, not subject or record ID.",
                  response = UserTerms.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Subject mapping successfully retrieved."),
                   @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
                   @ApiResponse(code = 500, message = "Unexpected error")})
    @RequestMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public ResponseEntity<UserTerms> getEntity(@PathVariable final Long id) {
        return new ResponseEntity<>(_service.retrieve(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Updates the indicated subject mapping.",
                  notes = "Based on primary key ID, not subject or record ID.",
                  response = Void.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Subject mapping successfully updated."),
                   @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
                   @ApiResponse(code = 500, message = "Unexpected error")})
    @RequestMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.PUT)
    public ResponseEntity<Void> updateEntity(@PathVariable final Long id, @RequestBody final UserTerms entity) {
        final UserTerms existing = _service.retrieve(id);
        //existing.setSubjectId(entity.getSubjectId());
        //existing.setSource(entity.getSource());
        _service.update(existing);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Deletes the indicated subject mapping.",
                  notes = "Based on primary key ID, not subject or record ID.",
                  response = Void.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Subject mapping successfully deleted."),
                   @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
                   @ApiResponse(code = 500, message = "Unexpected error")})
    @RequestMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteEntity(@PathVariable final Long id) {
        final UserTerms existing = _service.retrieve(id);
        _service.delete(existing);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Autowired
    private UserTermsService _service;
}
*/