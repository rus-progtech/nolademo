package com.niagarasummit.nola;

import javax.baja.alarm.*;
import javax.baja.collection.BITable;
import javax.baja.control.BNumericPoint;
import javax.baja.file.BIFile;
import javax.baja.history.ext.BHistoryExt;
import javax.baja.history.ext.BNumericCovHistoryExt;
import javax.baja.log.Log;
import javax.baja.naming.BOrd;
import javax.baja.naming.BOrdList;
import javax.baja.nre.annotations.*;
import javax.baja.status.BStatus;
import javax.baja.status.BStatusNumeric;
import javax.baja.status.BStatusValue;
import javax.baja.sys.*;
import javax.baja.units.BUnit;
import javax.baja.util.Lexicon;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Demonstration Class for Migrating a Niagara AX module to Niagara 4.
 * Used for Niagara Summit 2016 Developer Day.
 *
 */
@NiagaraType
/*
 Name of most recently spawned alligator
 */
@NiagaraProperty(
  name = "gatorName",
  type = "String",
  defaultValue = "Allie",
  flags = Flags.SUMMARY
)
/*
 Length of most recently spawned alligator
 */
@NiagaraProperty(
  name = "gatorLength",
  type = "BStatusNumeric",
  defaultValue = "new BStatusNumeric(0, BStatus.nullStatus)",
  flags = Flags.SUMMARY,
  facets = @Facet("BFacets.make(BFacets.UNITS, BUnit.getUnit(\"foot\"))")
)
/*
 Weight of most recently spawned alligator
 */
@NiagaraProperty(
  name = "gatorWeight",
  type = "BStatusNumeric",
  defaultValue = "new BStatusNumeric(0, BStatus.nullStatus)",
  flags = Flags.SUMMARY,
  facets = @Facet("BFacets.make(BFacets.UNITS, BUnit.getUnit(\"pound\"))")
)
/*
 Current record for longest alligator
 */
@NiagaraProperty(
  name = "recordLength",
  type = "double",
  defaultValue = "0",
  facets = @Facet("BFacets.make(BFacets.UNITS, BUnit.getUnit(\"foot\"))")
)
/*
 Logs all the alligators we've tracked
 */
@NiagaraProperty(
  name = "gatorLogger",
  type = "BHistoryExt",
  defaultValue = "makeEnabledHistoryExt()"
)
/*
 Generate a new Gator and track it.
 */
@NiagaraAction(
  name = "trackGator",
  parameterType = "BString",
  defaultValue = "BString.make(\"Allie\")"
)
/*
 Query the alarm database for the record-breaking gators.
 */
@NiagaraAction(
  name = "findRecordGators",
  returnType = "BComponent"
)
/*
 Write the list of gators to a file.
 */
@NiagaraAction(
  name = "writeGatorList"
)
/*
 Acknowledge the alarm from this ack request
 */
@NiagaraAction(
  name = "ackAlarm",
  parameterType = "BAlarmRecord",
  defaultValue = "new BAlarmRecord()",
  returnType = "BBoolean",
  flags = Flags.HIDDEN
)
/*
 Query for display names of child components
 */
@NiagaraAction(
  name = "displayNamesQuery"
)
@NiagaraTopic(
  name = "newGator"
)
public class BGatorTracker
  extends BNumericPoint
  implements BIAlarmSource
{

  /**
   * Make a history ext that's already enabled and ready to go.
   */
  private static BHistoryExt makeEnabledHistoryExt()
  {
	BHistoryExt ext = new BNumericCovHistoryExt();
	ext.setFlags(BHistoryExt.enabled, (ext.getFlags(BHistoryExt.enabled) & ~Flags.DEFAULT_ON_CLONE));
	ext.setEnabled(true);
	return ext;
  }
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.niagarasummit.nola.BGatorTracker(95062500)1.0$ @*/
/* Generated Thu Jul 04 14:09:28 ICT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "gatorName"

  /**
   * Slot for the {@code gatorName} property.
   * Name of most recently spawned alligator
   * @see #getGatorName
   * @see #setGatorName
   */
  public static final Property gatorName = newProperty(Flags.SUMMARY, "Allie", null);

  /**
   * Get the {@code gatorName} property.
   * Name of most recently spawned alligator
   * @see #gatorName
   */
  public String getGatorName() { return getString(gatorName); }

  /**
   * Set the {@code gatorName} property.
   * Name of most recently spawned alligator
   * @see #gatorName
   */
  public void setGatorName(String v) { setString(gatorName, v, null); }

  //endregion Property "gatorName"

  //region Property "gatorLength"

  /**
   * Slot for the {@code gatorLength} property.
   * Length of most recently spawned alligator
   * @see #getGatorLength
   * @see #setGatorLength
   */
  public static final Property gatorLength = newProperty(Flags.SUMMARY, new BStatusNumeric(0, BStatus.nullStatus), BFacets.make(BFacets.UNITS, BUnit.getUnit("foot")));

  /**
   * Get the {@code gatorLength} property.
   * Length of most recently spawned alligator
   * @see #gatorLength
   */
  public BStatusNumeric getGatorLength() { return (BStatusNumeric)get(gatorLength); }

  /**
   * Set the {@code gatorLength} property.
   * Length of most recently spawned alligator
   * @see #gatorLength
   */
  public void setGatorLength(BStatusNumeric v) { set(gatorLength, v, null); }

  //endregion Property "gatorLength"

  //region Property "gatorWeight"

  /**
   * Slot for the {@code gatorWeight} property.
   * Weight of most recently spawned alligator
   * @see #getGatorWeight
   * @see #setGatorWeight
   */
  public static final Property gatorWeight = newProperty(Flags.SUMMARY, new BStatusNumeric(0, BStatus.nullStatus), BFacets.make(BFacets.UNITS, BUnit.getUnit("pound")));

  /**
   * Get the {@code gatorWeight} property.
   * Weight of most recently spawned alligator
   * @see #gatorWeight
   */
  public BStatusNumeric getGatorWeight() { return (BStatusNumeric)get(gatorWeight); }

  /**
   * Set the {@code gatorWeight} property.
   * Weight of most recently spawned alligator
   * @see #gatorWeight
   */
  public void setGatorWeight(BStatusNumeric v) { set(gatorWeight, v, null); }

  //endregion Property "gatorWeight"

  //region Property "recordLength"

  /**
   * Slot for the {@code recordLength} property.
   * Current record for longest alligator
   * @see #getRecordLength
   * @see #setRecordLength
   */
  public static final Property recordLength = newProperty(0, 0, BFacets.make(BFacets.UNITS, BUnit.getUnit("foot")));

  /**
   * Get the {@code recordLength} property.
   * Current record for longest alligator
   * @see #recordLength
   */
  public double getRecordLength() { return getDouble(recordLength); }

  /**
   * Set the {@code recordLength} property.
   * Current record for longest alligator
   * @see #recordLength
   */
  public void setRecordLength(double v) { setDouble(recordLength, v, null); }

  //endregion Property "recordLength"

  //region Property "gatorLogger"

  /**
   * Slot for the {@code gatorLogger} property.
   * Logs all the alligators we've tracked
   * @see #getGatorLogger
   * @see #setGatorLogger
   */
  public static final Property gatorLogger = newProperty(0, makeEnabledHistoryExt(), null);

  /**
   * Get the {@code gatorLogger} property.
   * Logs all the alligators we've tracked
   * @see #gatorLogger
   */
  public BHistoryExt getGatorLogger() { return (BHistoryExt)get(gatorLogger); }

  /**
   * Set the {@code gatorLogger} property.
   * Logs all the alligators we've tracked
   * @see #gatorLogger
   */
  public void setGatorLogger(BHistoryExt v) { set(gatorLogger, v, null); }

  //endregion Property "gatorLogger"

  //region Action "trackGator"

  /**
   * Slot for the {@code trackGator} action.
   * Generate a new Gator and track it.
   * @see #trackGator(BString parameter)
   */
  public static final Action trackGator = newAction(0, BString.make("Allie"), null);

  /**
   * Invoke the {@code trackGator} action.
   * Generate a new Gator and track it.
   * @see #trackGator
   */
  public void trackGator(BString parameter) { invoke(trackGator, parameter, null); }

  //endregion Action "trackGator"

  //region Action "findRecordGators"

  /**
   * Slot for the {@code findRecordGators} action.
   * Query the alarm database for the record-breaking gators.
   * @see #findRecordGators()
   */
  public static final Action findRecordGators = newAction(0, null);

  /**
   * Invoke the {@code findRecordGators} action.
   * Query the alarm database for the record-breaking gators.
   * @see #findRecordGators
   */
  public BComponent findRecordGators() { return (BComponent)invoke(findRecordGators, null, null); }

  //endregion Action "findRecordGators"

  //region Action "writeGatorList"

  /**
   * Slot for the {@code writeGatorList} action.
   * Write the list of gators to a file.
   * @see #writeGatorList()
   */
  public static final Action writeGatorList = newAction(0, null);

  /**
   * Invoke the {@code writeGatorList} action.
   * Write the list of gators to a file.
   * @see #writeGatorList
   */
  public void writeGatorList() { invoke(writeGatorList, null, null); }

  //endregion Action "writeGatorList"

  //region Action "ackAlarm"

  /**
   * Slot for the {@code ackAlarm} action.
   * Acknowledge the alarm from this ack request
   * @see #ackAlarm(BAlarmRecord parameter)
   */
  public static final Action ackAlarm = newAction(Flags.HIDDEN, new BAlarmRecord(), null);

  /**
   * Invoke the {@code ackAlarm} action.
   * Acknowledge the alarm from this ack request
   * @see #ackAlarm
   */
  public BBoolean ackAlarm(BAlarmRecord parameter) { return (BBoolean)invoke(ackAlarm, parameter, null); }

  //endregion Action "ackAlarm"

  //region Action "displayNamesQuery"

  /**
   * Slot for the {@code displayNamesQuery} action.
   * Query for display names of child components
   * @see #displayNamesQuery()
   */
  public static final Action displayNamesQuery = newAction(0, null);

  /**
   * Invoke the {@code displayNamesQuery} action.
   * Query for display names of child components
   * @see #displayNamesQuery
   */
  public void displayNamesQuery() { invoke(displayNamesQuery, null, null); }

  //endregion Action "displayNamesQuery"

  //region Topic "newGator"

  /**
   * Slot for the {@code newGator} topic.
   * @see #fireNewGator
   */
  public static final Topic newGator = newTopic(0, null);

  /**
   * Fire an event for the {@code newGator} topic.
   * @see #newGator
   */
  public void fireNewGator(BValue event) { fire(newGator, event, null); }

  //endregion Topic "newGator"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BGatorTracker.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  
////////////////////////////////////////////////////////////////
// BComponent Overrides
////////////////////////////////////////////////////////////////
  
  /**
   * Initialize the Gator Tracker.
   */
  public void started() throws Exception
  {
    super.started();
    random = new Random();
  }
  
  /**
   * Override of BNumericPoint execution.
   */
  public void onExecute(BStatusValue out, Context cx)
  {
    out.copyFrom(getGatorLength());
  }

  
////////////////////////////////////////////////////////////////
// Actions
////////////////////////////////////////////////////////////////
  
  /**
   * Track a new alligator.
   */
  public void doTrackGator(BString gatorName)
  {
    // Create a gator
    BGator gator = createGator();
    
    // Add it to the family
    add(gatorName.getString(), gator);
    BStatusNumeric sn = new BStatusNumeric(gator.getLength());
    setGatorLength(sn);
    sn = new BStatusNumeric(gator.getWeight());
    setGatorWeight(sn);
    setGatorName(gatorName.toString());

    // Check if it's a new record
    double gatorLen = gator.getLength();
    if (gatorLen > getRecordLength())
    {
      // Generate alarm
      Map alarmData = new HashMap();
      alarmData.put(GATOR_NAME, gatorName);
      alarmData.put(GATOR_LENGTH, getGatorLength().getValueValue());
      alarmData.put(GATOR_WEIGHT, getGatorWeight().getValueValue());
      alarmData.put(OLD_RECORD, (BDouble)get(recordLength));
      alarmData.put(NEW_RECORD, getGatorLength().getValueValue());
      BAlarmRecord rec = new BAlarmRecord();
      rec.setAlarmData(BFacets.make(alarmData));
      rec.setSource(BOrdList.make(getNavOrd()));
      getAlarmService().routeAlarm(rec);
      
      // Update the record
      setRecordLength(gatorLen);
      gator.setIsRecord(true);
    }
    
    // The frozen history extension automatically logs the new addition...
    execute();

    // Fire a topic so interested parties can take action
    fireNewGator(null);
  }

  
////////////////////////////////////////////////////////////////
// BIAlarmSource
////////////////////////////////////////////////////////////////

  public BBoolean doAckAlarm(BAlarmRecord rec)
  {
    if (!isRunning()) return BBoolean.FALSE;
    
    // Acknowledge the alarm
    rec.setAckTime(Clock.time());
    rec.setAckState(BAckState.acked);
    rec.setAckRequired(false);
    
    try
    {
      getAlarmService().routeAlarm(rec);
    }
    catch (Exception e)
    {
      log.error(MessageFormat.format(lex.getText("gatorTracker.couldNotAck"),
          new Object[] { rec }));
    }
    
    return BBoolean.TRUE;
  }

  
////////////////////////////////////////////////////////////////
// Alarm API Usage
////////////////////////////////////////////////////////////////

  /**
   * Find all the alarms (new gator length records)
   * See Developer Doc topic at module://docDeveloper/doc/alarm.html
   */
  public BComponent doFindRecordGators()
  {
    BComponent gatorList = new BComponent();
    try
    {
      log.message(lex.getText("gatorTracker.recordGators.msg"));
      BOrdList source = BOrdList.make(getNavOrd());
      BAlarmService alarmService = getAlarmService();

//      // Niagara AX
//      Cursor cursor = alarmService.getAlarmDb().getAlarmsForSource(source);
      // Niagara 4
      Cursor<BAlarmRecord> cursor;
      try (AlarmDbConnection conn = alarmService.getAlarmDb().getDbConnection(null))
      {
        cursor = conn.getAlarmsForSource(source);
      int count = 0;
      while (cursor.next() & (++count < 10))
      {
        BAlarmRecord rec = (BAlarmRecord)cursor.get();
        BFacets alarmData = rec.getAlarmData();
        log.message(MessageFormat.format(
            lex.getText("gatorTracker.gatorStats"),
            new Object[] { alarmData.get(GATOR_LENGTH) }));
        gatorList.add(alarmData.gets(GATOR_NAME, null),
            new BGator(alarmData.geti(GATOR_LENGTH, 0), alarmData.geti(GATOR_WEIGHT, 0)));
      }
      }
    }
    catch (Exception e)
    {
      log.error(MessageFormat.format(
          lex.getText("gatorTracker.couldNotQuery"),
          new Object[] { "record gators" }));
      
    }
    return gatorList;
  }

  
////////////////////////////////////////////////////////////////
// Collections Usage
////////////////////////////////////////////////////////////////
  
  /**
   * Query for display names: demonstration of Collections API changes
   * See Developer Doc topic at module://docDeveloper/doc/collections.html
   */
  public void doDisplayNamesQuery()
  {
    try
    {
//      // Niagara AX
//      BICollection result = (BICollection)BOrd.make("bql:select displayName").get(this);
//      BITable table = result.toTable();
      // Niagara 4
      BITable<BObject> table = (BITable<BObject>)BOrd.make("bql:select displayName").get(this);

      StringBuffer sb = new StringBuffer();

//      // Niagara AX
//      for (int i=0; i<table.size(); i++)
      // Niagara 4
      Cursor<BObject> cursor = table.cursor();
      while (cursor.next())

      {
        sb.append(MessageFormat.format(
          lex.getText("gatorTracker.displayNames.result.elem"),

//          // Niagara AX
//          new Object[] { table.get(i), table.get(i).getType() })).append('\n');
          // Niagara 4
          new Object[] { cursor.get(), cursor.get().getType() })).append('\n');
      }
      log.message(MessageFormat.format(
          lex.getText("gatorTracker.displayNames.result"),
          new Object[] { sb.toString() }));
    }
    catch (Exception e)
    {
      log.error(MessageFormat.format(
          lex.getText("gatorTracker.couldNotQuery"),
          new Object[] { "display names" }));
    }
  }

  
////////////////////////////////////////////////////////////////
// File write
////////////////////////////////////////////////////////////////

  /**
   * Query the alarm database for all of the record-breaking gators,
   * and write them to the gator list file.
   * This is a demonstration of the file writes.  Note that the caret (^)
   * symbol, referred to "Station Home" in Niagara AX as the folder with
   * the station's name.  In Niagara 4, it refers to "Station Home", but this
   * is now the folder called "shared" underneath of the folder with the station's
   * name.  The folder with the station's name is now called "Protected Station Home",
   * and is not generally accessible by user code.
   */
  public void doWriteGatorList()
  {
    try
    {
      BIFile file = (BIFile)BOrd.make("file:^gator/gatorList.txt").get();
      OutputStream out = file.getOutputStream();
      BufferedWriter w = new BufferedWriter(new OutputStreamWriter(out));
      w.write(lex.getText("gatorTracker.gatorList.title") + '\n');

      log.message(lex.getText("gatorTracker.recordGators.msg"));
      BOrdList source = BOrdList.make(getNavOrd());
      BAlarmService alarmService = getAlarmService();

//      // Niagara AX
//      Cursor cursor = alarmService.getAlarmDb().getAlarmsForSource(source);
      // Niagara 4
      Cursor<BAlarmRecord> cursor;
      try (AlarmDbConnection conn = alarmService.getAlarmDb().getDbConnection(null))
      {
        cursor = conn.getAlarmsForSource(source);
      int count = 0;
      while (cursor.next() & (++count < 10))
      {
        BAlarmRecord rec = (BAlarmRecord)cursor.get();
        BFacets alarmData = rec.getAlarmData();
        w.write(MessageFormat.format(
            lex.getText("gatorTracker.gatorStats"),
            new Object[] { alarmData.get(GATOR_NAME), alarmData.get(GATOR_LENGTH), alarmData.get(GATOR_WEIGHT) }));
        w.write('\n');
      }
    }

      w.flush();
      w.close();
    }
    catch (Exception e)
    {
      log.error(MessageFormat.format(
          lex.getText("gatorTracker.writeList.error"),
          new Object[] { e })); 
    }
  }
  
  
////////////////////////////////////////////////////////////////
// Private Utility
////////////////////////////////////////////////////////////////

  /**
   * Get a reference to the station's {@code BAlarmService}.
   * Only valid in a running station.
   * @return the alarm service.
   */
  private BAlarmService getAlarmService()
  {
    return (BAlarmService) BOrd.make("service:alarm:AlarmService").get();
  }
  
  
////////////////////////////////////////////////////////////////
// Gator Creation
////////////////////////////////////////////////////////////////

  private BGator createGator()
  {
    int gLen = random.nextInt(MAX_GATOR_LENGTH);
    int weightPerFoot = random.nextInt(GATOR_WEIGHT_RANGE) + BASE_GATOR_WEIGHT_PER_FOOT;
    int gWt = gLen * weightPerFoot;
    BGator g = new BGator(gLen, gWt);
    return g;
  }
  
  Random random;
  public static final int MAX_GATOR_LENGTH = 16;
  public static final int GATOR_WEIGHT_RANGE = 20;
  public static final int BASE_GATOR_WEIGHT_PER_FOOT = 60;
  
  
////////////////////////////////////////////////////////////////
// Constants and Instance Fields
////////////////////////////////////////////////////////////////
  
  private static Lexicon lex = Lexicon.make("nola");
  private static Log log = Log.getLog("nola");

  public static final String GATOR_NAME = "GatorName";
  public static final String GATOR_LENGTH = "GatorLength";
  public static final String GATOR_WEIGHT = "GatorWeight";
  public static final String OLD_RECORD = "OldRecord";
  public static final String NEW_RECORD = "NewRecord";
  
}
