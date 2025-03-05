/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.flowable.cmmn.rest.service.api.runtime.variable;

import java.util.Map;

import org.flowable.common.rest.api.DataResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

/**
 * @author Tijs Rademakers
 */
@RestController
@Api(tags = { "Runtime" }, description = "Manage Runtime", authorizations = { @Authorization(value = "basicAuth") })
public class VariableInstanceCollectionResource extends VariableInstanceBaseResource {

    @ApiOperation(value = "List of variable instances", tags = { "History" }, nickname = "listVariableInstances")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "caseInstanceId", dataType = "string", value = "The case instance id of the variable instance.", paramType = "query"),
            @ApiImplicitParam(name = "taskId", dataType = "string", value = "The task id of the variable instance.", paramType = "query"),
            @ApiImplicitParam(name = "excludeTaskVariables", dataType = "boolean", value = "Indication to exclude the task variables from the result.", paramType = "query"),
            @ApiImplicitParam(name = "excludeLocalVariables", dataType = "boolean", value = "Indication to exclude local variables or not.", paramType = "query"),
            @ApiImplicitParam(name = "variableName", dataType = "string", value = "The variable name of the variable instance.", paramType = "query"),
            @ApiImplicitParam(name = "variableNameLike", dataType = "string", value = "The variable name using the like operator for the variable instance.", paramType = "query")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Indicates that variable instances could be queried."),
            @ApiResponse(code = 400, message = "Indicates an parameter was passed in the wrong format. The status-message contains additional information.") })
    @GetMapping(value = "/cmmn-runtime/variable-instances", produces = "application/json")
    public DataResponse<VariableInstanceResponse> getVariableInstances(@ApiParam(hidden = true) @RequestParam Map<String, String> allRequestParams) {
        VariableInstanceQueryRequest query = new VariableInstanceQueryRequest();

        // Populate query based on request
        if (allRequestParams.get("excludeTaskVariables") != null) {
            query.setExcludeTaskVariables(Boolean.valueOf(allRequestParams.get("excludeTaskVariables")));
        }

        if (allRequestParams.get("taskId") != null) {
            query.setTaskId(allRequestParams.get("taskId"));
        }

        if (allRequestParams.get("planItemInstanceId") != null) {
            query.setPlanItemInstanceId(allRequestParams.get("planItemInstanceId"));
        }

        if (allRequestParams.get("caseInstanceId") != null) {
            query.setCaseInstanceId(allRequestParams.get("caseInstanceId"));
        }

        if (allRequestParams.get("variableName") != null) {
            query.setVariableName(allRequestParams.get("variableName"));
        }

        if (allRequestParams.get("variableNameLike") != null) {
            query.setVariableNameLike(allRequestParams.get("variableNameLike"));
        }

        if (allRequestParams.get("excludeLocalVariables") != null) {
            query.setExcludeLocalVariables(Boolean.valueOf(allRequestParams.get("excludeLocalVariables")));
        }
        
        return getQueryResponse(query, allRequestParams);
    }
}
