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
package org.flowable.job.api;

import java.time.Duration;

/**
 * @author Filip Hrisafov
 */
public interface ExternalWorkerJobFailureBuilder {

    /**
     * The error message for the failing job.
     */
    ExternalWorkerJobFailureBuilder errorMessage(String errorMessage);

    /**
     * The longer error details for the failing job.
     */
    ExternalWorkerJobFailureBuilder errorDetails(String errorDetails);

    /**
     * The number of new retries that should be set for the job.
     * If not set then the retries count would be decreased by 1.
     * If the current retries is already 1, the job will be moved to the deadletter job table.
     */
    ExternalWorkerJobFailureBuilder retries(int retries);

    /**
     * The amount of time to wait before making the job available for a retry.
     * If nothing set then the job would immediately be available for a retry.
     */
    ExternalWorkerJobFailureBuilder retryTimeout(Duration retryTimeout);

    /**
     * Perform the logic for failing a job.
     */
    void fail();

}
