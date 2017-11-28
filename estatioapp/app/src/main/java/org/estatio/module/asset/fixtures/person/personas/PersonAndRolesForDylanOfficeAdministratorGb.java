/*
 *
 *  Copyright 2012-2014 Eurocommercial Properties NV
 *
 *
 *  Licensed under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.estatio.module.asset.fixtures.person.personas;

import org.estatio.module.asset.fixtures.person.PersonAndRolesAbstract;
import org.estatio.module.asset.fixtures.person.enums.Person_enum;
import org.estatio.module.party.dom.Person;
import org.estatio.module.party.fixtures.organisation.personas.OrganisationForYoukeaSe;

import lombok.Getter;

public class PersonAndRolesForDylanOfficeAdministratorGb extends PersonAndRolesAbstract {

    public static final Person_enum data = Person_enum.DylanOfficeAdministratorGb;

    public static final String REF = data.getRef();
    public static final String AT_PATH = data.getApplicationTenancy().getPath();
    public static final String SECURITY_USERNAME = REF.toLowerCase();

    public PersonAndRolesForDylanOfficeAdministratorGb() {
        super(data);
    }

    @Override
    protected void execute(ExecutionContext executionContext) {
        executionContext.executeChild(this, data.toFixtureScript());
    }

}