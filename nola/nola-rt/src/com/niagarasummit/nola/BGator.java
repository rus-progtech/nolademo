package com.niagarasummit.nola;

import javax.baja.sys.BAbsTime;
import javax.baja.sys.BFacets;
import javax.baja.sys.BStruct;
import javax.baja.sys.Flags;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.units.BUnit;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;

/**
 * Simple class to represent vital statistics of an alligator tracked by the
 * GatorTracker application.
 */
@NiagaraType
/*
 Time of creation
 */
@NiagaraProperty(
  name = "spawnTime",
  type = "BAbsTime",
  defaultValue = "BAbsTime.make()",
  flags = Flags.READONLY
)
/*
 Gator length
 */
@NiagaraProperty(
  name = "length",
  type = "int",
  defaultValue = "0",
  flags = Flags.READONLY,
  facets = @Facet("BFacets.make(BFacets.UNITS, BUnit.getUnit(\"foot\"))")
)
/*
 Gator weight
 */
@NiagaraProperty(
  name = "weight",
  type = "int",
  defaultValue = "0",
  flags = Flags.READONLY,
  facets = @Facet("BFacets.make(BFacets.UNITS, BUnit.getUnit(\"pound\"))")
)
/*
 Is this a record?
 */
@NiagaraProperty(
  name = "isRecord",
  type = "boolean",
  defaultValue = "false",
  flags = Flags.READONLY
)
public class BGator extends BStruct
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.niagarasummit.nola.BGator(1799066237)1.0$ @*/
/* Generated Thu Jul 04 14:09:28 ICT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "spawnTime"

  /**
   * Slot for the {@code spawnTime} property.
   * Time of creation
   * @see #getSpawnTime
   * @see #setSpawnTime
   */
  public static final Property spawnTime = newProperty(Flags.READONLY, BAbsTime.make(), null);

  /**
   * Get the {@code spawnTime} property.
   * Time of creation
   * @see #spawnTime
   */
  public BAbsTime getSpawnTime() { return (BAbsTime)get(spawnTime); }

  /**
   * Set the {@code spawnTime} property.
   * Time of creation
   * @see #spawnTime
   */
  public void setSpawnTime(BAbsTime v) { set(spawnTime, v, null); }

  //endregion Property "spawnTime"

  //region Property "length"

  /**
   * Slot for the {@code length} property.
   * Gator length
   * @see #getLength
   * @see #setLength
   */
  public static final Property length = newProperty(Flags.READONLY, 0, BFacets.make(BFacets.UNITS, BUnit.getUnit("foot")));

  /**
   * Get the {@code length} property.
   * Gator length
   * @see #length
   */
  public int getLength() { return getInt(length); }

  /**
   * Set the {@code length} property.
   * Gator length
   * @see #length
   */
  public void setLength(int v) { setInt(length, v, null); }

  //endregion Property "length"

  //region Property "weight"

  /**
   * Slot for the {@code weight} property.
   * Gator weight
   * @see #getWeight
   * @see #setWeight
   */
  public static final Property weight = newProperty(Flags.READONLY, 0, BFacets.make(BFacets.UNITS, BUnit.getUnit("pound")));

  /**
   * Get the {@code weight} property.
   * Gator weight
   * @see #weight
   */
  public int getWeight() { return getInt(weight); }

  /**
   * Set the {@code weight} property.
   * Gator weight
   * @see #weight
   */
  public void setWeight(int v) { setInt(weight, v, null); }

  //endregion Property "weight"

  //region Property "isRecord"

  /**
   * Slot for the {@code isRecord} property.
   * Is this a record?
   * @see #getIsRecord
   * @see #setIsRecord
   */
  public static final Property isRecord = newProperty(Flags.READONLY, false, null);

  /**
   * Get the {@code isRecord} property.
   * Is this a record?
   * @see #isRecord
   */
  public boolean getIsRecord() { return getBoolean(isRecord); }

  /**
   * Set the {@code isRecord} property.
   * Is this a record?
   * @see #isRecord
   */
  public void setIsRecord(boolean v) { setBoolean(isRecord, v, null); }

  //endregion Property "isRecord"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BGator.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  
  public BGator() {}
  
  public BGator(int l, int w)
  {
    setLength(l);
    setWeight(w);
  }
}
