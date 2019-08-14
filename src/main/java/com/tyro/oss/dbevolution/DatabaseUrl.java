/*
 * Copyright 2019 Tyro Payments Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tyro.oss.dbevolution;

import java.net.URI;

import static java.lang.String.valueOf;
import static org.apache.commons.lang3.StringUtils.substringAfter;

public class DatabaseUrl {

    private static final String DEFAULT_MYSQL_PORT = "3306";

    private final URI uri;

    public DatabaseUrl(String url) {
        uri = URI.create(substringAfter(url, "jdbc:"));
    }

    public String getPort() {
        int port = uri.getPort();
        return port == -1 ? DEFAULT_MYSQL_PORT : valueOf(port);
    }

    public String getSchemaName() {
        return substringAfter(uri.getPath(), "/");
    }

    public String getHost() {
        return uri.getHost();
    }
}