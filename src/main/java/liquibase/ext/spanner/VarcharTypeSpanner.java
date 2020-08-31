/**
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     https://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * package liquibase.ext.spanner;
 */

package liquibase.ext.spanner;
    
import liquibase.database.Database;
import liquibase.datatype.DatabaseDataType;
import liquibase.datatype.core.VarcharType;

public class VarcharTypeSpanner extends VarcharType {

    @Override
    public boolean supports(Database database) {
        return database instanceof CloudSpanner;
    }

    @Override
    public DatabaseDataType toDatabaseDataType(Database database) {
        if (database instanceof CloudSpanner) {
            return new DatabaseDataType("STRING(MAX)");
        } else {
            return super.toDatabaseDataType(database);
        }
    }

    @Override
    public int getPriority() {
        return 2;
    }

}
