/*
 *
 *  Copyright 2012-2013 Eurocommercial Properties NV
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
package org.estatio.dom.asset;

import java.math.BigInteger;
import java.util.List;

import org.joda.time.LocalDate;

import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.DescribedAs;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.NotContributed;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.annotation.Prototype;
import org.apache.isis.applib.services.bookmark.Bookmark;

import org.estatio.dom.EstatioDomainService;
import org.estatio.dom.geography.Country;
import org.estatio.dom.invoice.Constants;
import org.estatio.dom.numerator.Numerator;
import org.estatio.dom.numerator.Numerators;
import org.estatio.dom.utils.StringUtils;

public class Properties extends EstatioDomainService<Property> {

    public Properties() {
        super(Properties.class, Property.class);
    }

    // //////////////////////////////////////

    
    @ActionSemantics(Of.SAFE)
    @MemberOrder(name="Assets", sequence = "1")
    public Property newProperty(
            final @Named("Reference") String reference, 
            final @Named("Name") String name,
            final PropertyType propertyType, 
            final @Named("City") @Optional String city, 
            final @Optional Country country, 
            final @Named("Acquire date") @Optional LocalDate acquireDate) {
        final Property property = newTransientInstance();
        
        property.setReference(reference);
        property.setName(name);
        property.setPropertyType(propertyType);
        
        property.setCity(city);
        property.setCountry(country);
        property.setAcquireDate(acquireDate);
        
        persistIfNotAlready(property);
        return property;
    }
    public PropertyType default2NewProperty() {
        return PropertyType.MIXED;
    }

    // //////////////////////////////////////

    @Programmatic
    public List<Property> findProperties(String referenceOrName) {
        return allMatches("findByReferenceOrName", "referenceOrName", StringUtils.wildcardToRegex(referenceOrName));
    }

    @Programmatic
    public Property findPropertyByReference(final String reference) {
        return firstMatch("findByReference", "reference", StringUtils.wildcardToRegex(reference));
    }

    // //////////////////////////////////////

    @Hidden
    public List<Property> autoComplete(String searchPhrase) {
        return findProperties("*".concat(searchPhrase).concat("*"));
    }

    
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(name="Assets", sequence = "99")
    public List<Property> allProperties() {
        return allInstances();
    }

    
}
