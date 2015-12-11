/*
 * Copyright (C) 2015 nuno
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package model;

/**
 *
 * @author nuno
 */
public class Disc implements Comparable<Disc>, Cloneable {

    private int diameter;

    /**
     * Void constructor. Use set to fill attribute objects
     */
    public Disc() {
    }

    /**
     * Main constructor. initialize the object with attribute values.
     *
     * @param diameter int
     */
    public Disc(int diameter) {
        this.setDiameter(diameter);
    }

    /**
     * Copy constructor. Clone other object Disc.
     *
     * @param other
     */
    private Disc(Disc other) {
        this(other.getDiameter());
    }

    /**
     * Gives it back attribute value.
     *
     * @return diameter int
     */
    public int getDiameter() {
        return diameter;
    }

    /**
     * Set attribute value
     *
     * @param diameter int
     */
    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.diameter;
        return hash;
    }

    /**
     * Allows you to compare two objects. True if have same diameter value.
     *
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disc other = (Disc) obj;
        return this.diameter == other.diameter;
    }

    @Override
    public String toString() {
        return "Disco " + diameter;
    }

    /**
     * Compare two disc objects.
     *
     * @param o
     * @return int
     */
    @Override
    public int compareTo(Disc o) {
        if (this.getDiameter() > o.getDiameter()) {
            return 1;
        } else {
            if (this.getDiameter() < o.getDiameter()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    /**
     * Returns a new instance of disc, with same values attributes
     *
     * @return Disc clone object
     */
    @Override
    public Disc clone() {
        return new Disc(this);
    }

}
