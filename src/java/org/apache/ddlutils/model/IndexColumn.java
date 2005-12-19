package org.apache.ddlutils.model;

/*
 * Copyright 1999-2005 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
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

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Represents a column of an index in the database model.
 * 
 * @author Thomas Dudziak
 * @version $Revision$
 */
public class IndexColumn implements Cloneable, Serializable
{
    /** Unique ID for serialization purposes. */
    private static final long serialVersionUID = -5009366896427504739L;

    /** The name of the column. */
    protected String _name;
    /** The size of the column in the index. */
    protected String _size;

    // TODO: It might be useful if the referenced column is directly acessible here ?

    /**
     * Creates a new index column object.
     */
    public IndexColumn()
    {
    }
    
    /**
     * Creates a new index column object.
     * 
     * @param columnName The name of the corresponding table column
     */
    public IndexColumn(String columnName)
    {
        _name = columnName;
    }
    
    /**
     * Returns the name of the column.
     * 
     * @return The name
     */
    public String getName()
    {
        return _name;
    }
    
    /**
     * Sets the name of the column.
     * 
     * @param name The name
     */
    public void setName(String name)
    {
        _name = name;
    }

    /**
     * Returns the size of the column in the index.
     * 
     * @return The size
     */
    public String getSize()
    {
        return _size;
    }

    /**
     * Sets the size of the column in the index.
     * 
     * @param size The size
     */
    public void setSize(String size)
    {
        _size = size;
    }

    /**
     * {@inheritDoc}
     */
    public Object clone() throws CloneNotSupportedException
    {
        IndexColumn result = (IndexColumn)super.clone();

        result._name = _name;
        result._size = _size;
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public boolean equals(Object obj)
    {
        if (obj instanceof IndexColumn)
        {
            IndexColumn other = (IndexColumn)obj;

            // Note that this compares case sensitive
            return new EqualsBuilder().append(_name, other._name)
                                      .append(_size, other._size)
                                      .isEquals();
        }
        else
        {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    public int hashCode()
    {
        return new HashCodeBuilder(17, 37).append(_name)
                                          .append(_size)
                                          .toHashCode();
    }

    /**
     * {@inheritDoc}
     */
    public String toString()
    {
        StringBuffer result = new StringBuffer();

        result.append("Index column [name=");
        result.append(getName());
        result.append("; size=");
        result.append(getSize());
        result.append("]");

        return result.toString();
    }
}
