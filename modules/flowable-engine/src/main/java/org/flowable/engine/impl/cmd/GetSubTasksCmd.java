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

package org.flowable.engine.impl.cmd;

import java.io.Serializable;
import java.util.List;

import org.flowable.common.engine.impl.interceptor.Command;
import org.flowable.common.engine.impl.interceptor.CommandContext;
import org.flowable.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.flowable.engine.impl.util.CommandContextUtil;
import org.flowable.task.api.Task;

/**
 * @author Tom Baeyens
 */
public class GetSubTasksCmd implements Command<List<Task>>, Serializable {

    private static final long serialVersionUID = 1L;
    protected String parentTaskId;

    public GetSubTasksCmd(String parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    @Override
    public List<Task> execute(CommandContext commandContext) {
        ProcessEngineConfigurationImpl processEngineConfiguration = CommandContextUtil.getProcessEngineConfiguration(commandContext);
        return processEngineConfiguration.getTaskServiceConfiguration().getTaskService().findTasksByParentTaskId(parentTaskId);
    }

}
