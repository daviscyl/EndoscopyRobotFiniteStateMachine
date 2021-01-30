package controller;

public class FiniteStateMachine {
  public static final AbstractState initialState = new InitialState();
  public static final AbstractState pBInflationState = new PBInflationState();
  public static final AbstractState pBDeflationState = new PBDeflationState();
  public static final AbstractState mBExpansionState = new MBExpansionState();
  public static final AbstractState mBContractionsState = new MBContractionState();
  public static final AbstractState dBInflationState = new DBInflationState();
  public static final AbstractState dBDeflationState = new DBDeflationState();
  public static final AbstractState anchorsState = new AnchorState();

  public static AbstractState currentState = initialState;

  public static void initStates() {
    initialState.setNextState(mBExpansionState);
    initialState.setPrevState(mBContractionsState);

    pBInflationState.setNextState(dBDeflationState);
    dBDeflationState.setNextState(mBExpansionState);
    mBExpansionState.setNextState(dBInflationState);
    dBInflationState.setNextState(pBDeflationState);
    pBDeflationState.setNextState(mBContractionsState);
    mBContractionsState.setNextState(pBInflationState);

    pBInflationState.setPrevState(mBContractionsState);
    mBContractionsState.setPrevState(pBDeflationState);
    pBDeflationState.setPrevState(dBInflationState);
    dBInflationState.setPrevState(mBExpansionState);
    mBExpansionState.setPrevState(dBDeflationState);
    dBDeflationState.setPrevState(pBInflationState);
  }
}
